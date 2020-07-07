package edu.csuft.Bruno.jedis.util;
/**
 * 工具类：连接Redis数据库
 * @author Bruno
 *
 */

import redis.clients.jedis.Jedis;

public class JedisUtil {

	//远程访问Redis服务器的IP地址
	private static final String ADDRESS = "localhost";
	//远程Redis服务器开启的端口号
	private static final int PORT = 6379;
	//设置连接远程Redis服务器的密码
	private static final String passwd = "redis";
	
	/**
	 * 
	 * @return 返回一个客户端连接对象
	 */
	public Jedis getJedis() {
		//创建Jedis对象代表的是一个客户端的连接
		Jedis jedis = new Jedis();
		//设置Redis连接密码
		jedis.auth(passwd);
		return jedis;
	}
}
