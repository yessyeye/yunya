package com.xuehai.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.xuehai.base.Log;
import org.bson.BsonDocument;
import org.bson.Document;

import java.sql.*;
import java.util.*;

/**
 * 
 * @ClassName: SQLExecutor
 * @Description: 数据库执行器
 * @author Sniper
 * @date 2018-09-30 15:26:14
 *
 */
public class SQLExecutor {
	private static final Log LOGGER = new Log(SQLExecutor.class);
	private static Connection conn;
	private static PreparedStatement pstat;
	private static ResultSet rs;
	private static MongoClient mongoClient;
	
	/**
	 * 
     * @Title: 								数据库查询	
     * @Description: 	
     * @param dbSource						数据源
     * @param sql							sql语句
     * @return List<Map<String,Object>>		返回查询字段的Map集合	
	 */
	public static List<Map<String, Object>> query(String dbSource, String sql) {
		List<Map<String, Object>> list = null;
		try {
			try {
				conn = getConnection(dbSource);
				pstat = conn.prepareStatement(sql);
				LOGGER.info("执行 sql: \"" + sql + "\"");
				rs = pstat.executeQuery();
				list = new ArrayList<Map<String, Object>>();
				ResultSetMetaData rsMetaData = rs.getMetaData();
				int mdColumns = rsMetaData.getColumnCount();
				while (rs.next()) {
					Map<String, Object> rowData = new HashMap<String, Object>();
					for (int i = 1; i <= mdColumns; i++) {
						rowData.put(rsMetaData.getColumnName(i), rs.getObject(i));
					}
					list.add(rowData);
				}
			} finally {
				closeConnection();
			}
		}catch (SQLException e) {
			LOGGER.error("数据库异常", e);
		} 
		return list;
	}

	/**
	 * 
     * @Title: 								数据库查询	
     * @Description: 							
     * @param dbSource						数据源
     * @param sql							sql语句
     * @param sqlParams						sql where条件
     * @return List<Map<String,Object>>		返回查询字段的Map集合
	 */
	public static List<Map<String, Object>> query(String dbSource, String sql, Map<String, String> sqlParams) {
		List<Map<String, Object>> list = null;
		try {
			try {
				int num = 0;
				conn = getConnection(dbSource);
				Iterator<Map.Entry<String, String>> it = sqlParams.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();
					if (num == 0) {
						sql += " where " + entry.getKey() + "='" + entry.getValue() + "'";
						num++;
					} else {
						sql += " and " + entry.getKey() + "='" + entry.getValue() + "'";
					}
				}
				pstat = conn.prepareStatement(sql);
				LOGGER.info("执行 sql: \"" + sql + "\"");
				rs = pstat.executeQuery();
				list = new ArrayList<Map<String, Object>>();
				ResultSetMetaData rsMetaData = rs.getMetaData();
				int mdColumns = rsMetaData.getColumnCount();
				while (rs.next()) {
					Map<String, Object> rowData = new HashMap<String, Object>();
					for (int i = 1; i <= mdColumns; i++) {
						rowData.put(rsMetaData.getColumnName(i), rs.getObject(i));
					}
					list.add(rowData);
				}
			} finally {
				closeConnection();
			}
		}catch (SQLException e) {
			LOGGER.error("数据库异常", e);
		}
		return list;
	}

	/**
	 * 
     * @Title: 				数据库执行
     * @Description: 
     * @param dbSource		数据源
     * @param sql			sql语句
     * @return void
	 */
	public static void execute(String dbSource, String sql) {
		try {
			try {
				conn = getConnection(dbSource);
				pstat = conn.prepareStatement(sql);
				LOGGER.info("执行 sql: \"" + sql + "\"");
				pstat.execute();
			
			} finally {
				closeConnection();
			}
		} catch (SQLException e) {
			LOGGER.error("数据库异常", e);
		}
	}

	/**
	 * 
     * @Title: 				数据库执行
     * @Description: 
     * @param dbSource		数据源
     * @param sql			sql语句
     * @param sqlParams		sql where 条件
     * @return void
	 */
	public static void execute(String dbSource, String sql, Map<String, String> sqlParams) {
		try {
			try {
				conn = getConnection(dbSource);
				int num = 0;
				Iterator<Map.Entry<String, String>> it = sqlParams.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();
					if (num == 0) {
						sql += " where " + entry.getKey() + "=" + entry.getValue();
						num++;
					} else {
						sql += " and " + entry.getKey() + "=" + entry.getValue();
					}
				}
				pstat = conn.prepareStatement(sql);
				LOGGER.info("执行 sql: \"" + sql + "\"");
				pstat.execute();
			} finally {
				closeConnection();
			}
		}catch (SQLException e) {
			LOGGER.error("数据库异常", e);
		} 
	}
	
	/**
	 * 
     * @Title: 				连接数据库并返回
     * @Description: 
     * @param dbSource		数据源
     * @return
     * @return Connection	返回数据库连接
	 */
	public static Connection getConnection(String dbSource) {
		try {
			if (conn==null || conn.isClosed()) {
				JSONObject source = JSONObject.parseObject(dbSource);
				String driverName = source.getString("driver");
				String url = source.getString("url");
				String user = source.getString("user");
				String password = source.getString("password");
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (ClassNotFoundException e) {
			LOGGER.error("数据库连接异常", e);
		} catch (SQLException e) {
			LOGGER.error("数据库连接异", e);
		}
		return conn;
	}

	/**
	 * 
     * @Title: 			关闭数据库连接
     * @Description: 
     * @return void
	 */
	public static void closeConnection() {
		try {
			if (rs != null)
			rs.close();
			if (pstat != null)
				pstat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			LOGGER.error("数据库关闭异常", e);
		}
	}
	
	/**
	 * 
	 * @Title: 								mongodb查询数据 
	 * @Description: 						
	 * @param host							主机名
	 * @param port							端口
	 * @param database						数据库名
	 * @param collection					collection名称
	 * @param queryJson						查询json串,如:{"find":{查询条件,可为空},"projection":{返回指定字段},"sort":{排序},"skip":{分页},"limit":1}
	 * @return List<Map<String, Object>>	返回字段Map集合
	 */
	public static List<Map<String, Object>> query(String dbSource, String collection, String queryJson) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		MongoCursor<Document> cursor = null;
		try {
			JSONObject source = JSONObject.parseObject(dbSource);
			String host = source.getString("host");
			int port = source.getIntValue("port");
			String database = source.getString("database");
			mongoClient = getMongoClient(host, port);
			MongoDatabase db = mongoClient.getDatabase(database);
			MongoCollection<Document> coll = db.getCollection(collection);
			FindIterable<Document> doc = null;
			JSONObject query = JSONObject.parseObject(queryJson);
			if (queryJson.contains("find")) {
				String findParams = query.getString("find");
				BsonDocument findDoc = BsonDocument.parse(findParams);
				doc = coll.find(findDoc);
			} else {
				doc = coll.find();
			}
			for (String key : query.keySet()) {
				switch (key) {
					case "projection" : 
						String projectionParams = query.getString("projection");
						BsonDocument projectionDoc = BsonDocument.parse(projectionParams);
						doc = doc.projection(projectionDoc);
						break;
					case "sort" :
						String sortParams = query.getString("sort");
						BsonDocument sortDoc = BsonDocument.parse(sortParams);
						doc = doc.sort(sortDoc);
						break;
					case "skip" :
						int skip = query.getIntValue("skip");
						doc = doc.skip(skip);
						break;
					case "limit" :
						int limit = query.getIntValue("limit");
						doc = doc.limit(limit);
						break;
				}
			}
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
	 * 
	 * @Title: 				mongodb查询记录条数 
	 * @Description: 		
	 * @param host			主机名
	 * @param port			端口
	 * @param database		数据库名
	 * @param collection	collection名称
	 * @param queryJson		查询json串,如:{"find":{查询条件,可为空}}
	 * @return long			返回count数
	 */
	public static long count(String dbSource, String collection, String queryJson) {
		try {
			JSONObject source = JSONObject.parseObject(dbSource);
			String host = source.getString("host");
			int port = source.getIntValue("port");
			String database = source.getString("database");
			mongoClient = getMongoClient(host, port);
			MongoDatabase db = mongoClient.getDatabase(database);
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
			JSONObject source = JSONObject.parseObject(dbSource);
			String host = source.getString("host");
			int port = source.getIntValue("port");
			String database = source.getString("database");
			mongoClient = getMongoClient(host, port);
			MongoDatabase db = mongoClient.getDatabase(database);
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
	 * 
     * @Title: 					创建MongoClient实例
     * @Description: 	
     * @param host				主机名		
     * @param port				端口
     * @return MongoClient		返回MongoClient实例
	 */
	public static MongoClient getMongoClient(String host, int port) {
		if(mongoClient == null)
			mongoClient = new MongoClient(host, port);
		return mongoClient;
	}
	
	/**
	 * 
     * @Title: 			关闭Mongo数据库连接
     * @Description: 
     * @return void
	 */
	public static void closeMongoClient() {
		if(mongoClient != null) {
			mongoClient.close();
			mongoClient = null;
		}
	}
}
