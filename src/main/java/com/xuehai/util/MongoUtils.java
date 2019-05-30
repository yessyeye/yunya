package com.xuehai.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.*;


/**
 * mongo 数据库查询类
 */
public class MongoUtils {
    private static MongoClient mongoClient; // 用于 mongo 数据库操作

    /**
     * 引用 db 配置文件中选择的数据库类型，以及库
     */
    public static void main(String[] args) {
        String dbSource = CommonUtils.getProperty(CommonUtils.getConfigProperty("db_source"), "mongo_new_test");
        System.out.println(dbSource);
        MongoDatabase db = getDatabase(dbSource);
        System.out.println(db);
    }

    // 直接查询 --- 查询id 为 ,目前暂无其它很好的方式
    public static <Aggregation> List<Map<String, Object>> queryFind(String dbSource, String collection, String sql) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        MongoCursor<Document> cursor = null;
        try {
            MongoDatabase db = getDatabase(dbSource);
            MongoCollection<Document> coll = db.getCollection(collection);
            FindIterable<Document> doc = null;
            BsonDocument findDoc = BsonDocument.parse(sql);
            doc = coll.find(findDoc);
            cursor = doc.iterator();
            while (cursor.hasNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                Document document = cursor.next();
                for (Map.Entry<String, Object> entry : document.entrySet()) {
                    String key = entry.getKey().toString();
                    Object value = entry.getValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            closeMongoClient();
        }
        return list;
    }

    /**
     * @param host       主机名
     * @param port       端口
     * @param database   数据库名
     * @param collection collection名称
     * @param queryJson  查询json串,如:{"find":{查询条件,可为空},"projection":{返回指定字段},"sort":{排序},"skip":{分页},"limit":1}
     * @Title: mongodb 删除数据
     * @Description:
     */
    public static void delete(String dbSource, String collection, String queryJson) {
        MongoCursor<Document> cursor = null;
        try {
            MongoDatabase db = getDatabase(dbSource); // 数据库连接
            MongoCollection<Document> coll = db.getCollection(collection); // 找到对应表
            JSONObject query = JSONObject.parseObject(queryJson); // 解析我的 sql 语句
            // 这里需要改...目前只有查询操作，需要添加删除、修改、增加等操作
            if (queryJson.contains("delete")) {
                String findParams = query.getString("delete");
                BsonDocument findDoc = BsonDocument.parse(findParams);
                coll.deleteOne(findDoc);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            closeMongoClient();
        }
    }

    /**
     * @param host       主机名
     * @param port       端口
     * @param database   数据库名
     * @param collection collection名称
     * @param queryJson  查询json串,如:{"find":{查询条件,可为空},"projection":{返回指定字段},"sort":{排序},"skip":{分页},"limit":1}
     * @Title: mongodb查询数据
     * @Description:
     */
    public static List<Map<String, Object>> query(String dbSource, String collection, String queryJson) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        MongoCursor<Document> cursor = null;
        try {
            MongoDatabase db = getDatabase(dbSource); // 数据库连接
            MongoCollection<Document> coll = db.getCollection(collection); // 找到对应表
            FindIterable<Document> doc = null;
            JSONObject query = JSONObject.parseObject(queryJson); // 解析我的 sql 语句
            if (queryJson.contains("find")) {
                String findParams = query.getString("find");
                BsonDocument findDoc = BsonDocument.parse(findParams);
                doc = coll.find(findDoc);
            } else {
                doc = coll.find();
            }
            for (String key : query.keySet()) {
                switch (key) {
                    case "projection":
                        String projectionParams = query.getString("projection");
                        BsonDocument projectionDoc = BsonDocument.parse(projectionParams);
                        doc = doc.projection(projectionDoc);
                        break;
                    case "sort":
                        String sortParams = query.getString("sort");
                        BsonDocument sortDoc = BsonDocument.parse(sortParams);
                        doc = doc.sort(sortDoc);
                        break;
                    case "skip":
                        int skip = query.getIntValue("skip");
                        doc = doc.skip(skip);
                        break;
                    case "limit":
                        int limit = query.getIntValue("limit");
                        doc = doc.limit(limit);
                        break;
                }
            }
            // 遍历数据库查询
            cursor = doc.iterator();
            while (cursor.hasNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                Document document = cursor.next();
                for (Map.Entry<String, Object> entry : document.entrySet()) {
                    String key = entry.getKey().toString();
                    Object value = entry.getValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            closeMongoClient();
        }
        return list;
    }

    /**
     * @param host       主机名
     * @param port       端口
     * @param database   数据库名
     * @param collection collection名称
     * @param queryJson  查询json串,如:{"find":{查询条件,可为空}}
     * @return long            返回count数
     * @Title: mongodb查询记录条数
     * @Description:
     */
    public static long count(String dbSource, String collection, String queryJson) {
        try {
            MongoDatabase db = getDatabase(dbSource);
            MongoCollection<Document> coll = db.getCollection(collection);
            JSONObject query = JSONObject.parseObject(queryJson);
            if (query.containsKey("find")) {
                JSONObject findParams = query.getJSONObject("find");
                BsonDocument findDoc = BsonDocument.parse(findParams.toString());
                return coll.count(findDoc);
            } else {
                return coll.count();
            }
        } finally {
            closeMongoClient();
        }
    }

    public static List<Map<String, Object>> aggregate(String dbSource, String collection, String aggregateJson) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        MongoCursor<Document> cursor = null;
        try {
            MongoDatabase db = getDatabase(dbSource);
            MongoCollection<Document> coll = db.getCollection(collection);
            JSONArray array = JSONArray.parseArray(aggregateJson);
            List<BsonDocument> bsonList = new ArrayList<BsonDocument>();
            for (Object temp : array) {
                BsonDocument bson = BsonDocument.parse(temp.toString());
                bsonList.add(bson);
            }
            AggregateIterable<Document> docIterator = coll.aggregate(bsonList);
            cursor = docIterator.iterator();
            while (cursor.hasNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                Document document = cursor.next();
                for (Map.Entry<String, Object> entry : document.entrySet()) {
                    String key = entry.getKey().toString();
                    Object value = entry.getValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            closeMongoClient();
        }
        return list;
    }

    /**
     * @param host 主机名
     * @param port 端口
     * @return MongoClient        返回MongoClient实例
     * @Title: 创建MongoClient实例
     * @Description:
     */
    public static MongoDatabase getDatabase(String dbSource) {
        JSONObject source = JSONObject.parseObject(dbSource);
        String host = source.getString("host");
        int port = source.getIntValue("port");
        String database = source.getString("database");
        String userName = source.getString("userName");
        String password = source.getString("password");
        String dbName = source.getString("dbName");
        if (mongoClient == null) {
            ServerAddress serverAddress = new ServerAddress(host, port);
            if (userName != null && password != null) {
//				String sURI = String.format("mongodb://%s:%s@%s:%d/%s",userName,password,host,port,database);
//				MongoClientURI uri = new MongoClientURI(sURI);
//				mongoClient = new MongoClient(uri);
                // 认证失败了
                MongoCredential credential = MongoCredential.createCredential(userName, database, password.toCharArray());
                mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
            } else {
                mongoClient = new MongoClient(serverAddress);
            }
        }
        return mongoClient.getDatabase(dbName); // 连接对应库
//		return mongoClient.getDatabase(database);
    }

    /**
     * @return void
     * @Title: 关闭Mongo数据库连接
     * @Description:
     */
    public static void closeMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }

    /**
     * 模糊查询
     *
     * @param dbSource
     * @param collection
     * @param queryJson
     * @return
     */
    public static long search(String dbSource, String collection, String queryJson) {
        try {
            MongoDatabase db = getDatabase(dbSource);
            MongoCollection<Document> coll = db.getCollection(collection);
            JSONObject query = JSONObject.parseObject(queryJson);
            if (query.containsKey("find")) {
                JSONObject findParams = query.getJSONObject("find");
                String sql = findParams.toString();
                sql = sql.replace("\"/", "/")
                        .replace("/i\"", "/i");
                BsonDocument findDoc = BsonDocument.parse(sql);
                return coll.count(findDoc);
            } else {
                return coll.count();
            }
        } finally {
            closeMongoClient();
        }
    }
}
