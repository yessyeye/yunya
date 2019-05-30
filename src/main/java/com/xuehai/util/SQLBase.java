package com.xuehai.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.File;
import java.util.List;
import java.util.Map;

public class SQLBase {
	public static JSONArray getSQLResult(String sql) {
		SQLExecutor executor = new SQLExecutor();
		//配置文件路径
		String pathname = System.getProperty("user.dir")+File.separator+"src"+File.separator+
				"main"+File.separator+"resources"+File.separator+"config"+
				File.separator+"dbsource.properties";
		//读取数据库配置
		String dbSource = Utils.getProperties(pathname,"mysql").toString();
		List<Map<String, Object>> resList = executor.query(dbSource, sql);
		//转成jsonarray
		JSONArray sqlJarray= JSONArray.parseArray(JSON.toJSONString(resList));
		executor.closeConnection();
		return sqlJarray; 
	}

}
