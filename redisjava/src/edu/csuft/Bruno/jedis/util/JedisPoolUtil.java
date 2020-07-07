package edu.csuft.Bruno.jedis.util;
/**
 * 创建Jedis连接池工具类
 * @author Bruno
 *
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	// 声明一个JedisPOOl连接池对象
	private static JedisPool jedisPool;
	// 声明一个JedisPoolConfig连接池配置对象
	private static JedisPoolConfig jedisPoolConfig;

	// 1.创建Jedis连接池相关配置
	static {
		if (jedisPool != null) {
			jedisPoolConfig = new JedisPoolConfig();

			// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
			jedisPoolConfig.setBlockWhenExhausted(true);

			// 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
			jedisPoolConfig.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");

			// 是否启用pool的jmx管理功能, 默认true
			// config.setJmxEnabled(true);

			// 默认为"pool"。
			// config.setJmxNamePrefix("JedisPool");

			// 是否启用后进先出, 默认true
			jedisPoolConfig.setLifo(true);

			// 最大空闲连接数, 默认8个
			jedisPoolConfig.setMaxIdle(8);

			// 最大连接数, 默认8个
			jedisPoolConfig.setMaxTotal(30);

			// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间, 默认-1
			jedisPoolConfig.setMaxWaitMillis(30000);

			// 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
			jedisPoolConfig.setMinEvictableIdleTimeMillis(1800000);

			// 最小空闲连接数, 默认0
			jedisPoolConfig.setMinIdle(5);

			// 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
			// config.setNumTestsPerEvictionRun(3);

			// 对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断
			// (默认逐出策略)
			jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1800000);

			// 在获取连接的时候检查有效性, 默认false
			// 向资源池借用连接时是否做连接有效性检测（ping）。检测到的无效连接将会被移除。业务量很大时候建议设置为false，减少一次ping的开销。
			jedisPoolConfig.setTestOnBorrow(false);

			// 在空闲时检查有效性, 默认false
			jedisPoolConfig.setTestWhileIdle(false);

			// 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
			jedisPoolConfig.setTimeBetweenEvictionRunsMillis(-1);

			/*
			 * 创建连接池对象 参数一：连接池配置 参数二：IP地址 参数三:Port 参数四：连接的超时设置(单位：毫秒) 参数五：登录密码
			 */
			jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379, 30000, "redis");
		}
	}

	// 获取Jedis客户端连接对象
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}

	// 销毁JedisPool
	public static void jedisPoolClose() {
		jedisPool.close();
	}

}
