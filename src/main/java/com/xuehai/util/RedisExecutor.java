package com.xuehai.util;

import redis.clients.jedis.Jedis;

/**
 * 
 * @ClassName: RedisExecutor
 * @Description: redis操作类
 * @author Sniper
 * @date 2018-09-11 11:09:05
 *
 */
public class RedisExecutor {
	private static Jedis jedis;
	
	/**
	 * 
     * @Title: 			getValue
     * @Description: 	取值
     * @param host		主机名
     * @param port		端口
     * @param key		key
     * @return
     * @return Object
	 */
	public static Object getValue(String host, int port, String key) {
		Object obj = null;
		try{
			jedis = getInstance(host, port);
			obj = jedis.get(key);
		} finally {
			close();
		}
		return obj;
	}
	
	/**
	 * 
     * @Title: 			getJedis
     * @Description: 	获取redis实例
     * @param host		主机名
     * @param port		端口
     * @return
     * @return Jedis	
	 */
	public static Jedis getInstance(String host, int port) {
		if (jedis == null) {
			jedis = new Jedis(host, port);
		}
		return jedis;
	}
	
	/**
	 * 
     * @Title: close
     * @Description: 	关闭连接
     * @return void
	 */
	public static void close() {
		jedis.close();
	}
	
}
