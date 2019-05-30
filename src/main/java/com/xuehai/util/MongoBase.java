package com.xuehai.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;


/**
 * @Author slyart
 * @create 2019/5/14 3:37 PM
 */
public class MongoBase {
    // 查询方法1
    public JSONArray getMongoResult(String collection, String sql) {
        MongoUtils executor = new MongoUtils();
        //读取数据库配置
        String dbSource = CommonUtils.getProperties(CommonUtils.getConfigProperties("db_source").toString(),
                "mongo_test").toString();
        System.out.println(dbSource);
        List<Map<String, Object>> list = executor.query(dbSource, collection, sql);
        //转成jsonarray
        SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
        serializeConfig.put(ObjectId.class, ObjectIdSerializer.instance);
        JSONArray sqlJarray = JSONArray.parseArray(JSON.toJSONString(list, serializeConfig));

        return sqlJarray;
    }

    // 删除方法
    public void getMongoDelete(String collection, String sql) {
        MongoUtils executor = new MongoUtils();
        //读取数据库配置
        String dbSource = CommonUtils.getProperties(CommonUtils.getConfigProperties("db_source").toString(),
                "mongo_test").toString();
        executor.delete(dbSource, collection, sql);
    }

    public JSONArray getMongoResultFind(String collection, String sql) {
        MongoUtils executor = new MongoUtils();
        //读取数据库配置
        String dbSource = CommonUtils.getProperties(CommonUtils.getConfigProperties("db_source").toString(),
                "mongo_test").toString();
        System.out.println(dbSource);
        List<Map<String, Object>> list = executor.queryFind(dbSource, collection, sql);
        //转成jsonarray
        SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
        serializeConfig.put(ObjectId.class, ObjectIdSerializer.instance);
        JSONArray sqlJarray = JSONArray.parseArray(JSON.toJSONString(list, serializeConfig));
        return sqlJarray;
    }
}
