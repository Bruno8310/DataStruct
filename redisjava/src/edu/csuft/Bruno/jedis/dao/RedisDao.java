package edu.csuft.Bruno.jedis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import edu.csuft.Bruno.jedis.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 与Redis数据库进行数据交互操作
 * @author Bruno
 *
 */
public class RedisDao {

	//测试redis的远程连接
		public byte[] testJoin() {
			Jedis jedis =  this.getJedis();
			byte[] bytes = jedis.ping("Hello World".getBytes());
			jedis.close();
			return bytes;
		}
		
		//redis中 添加一个String数据类型
		public String addStringKey(String key,String value) {
			Jedis jedis = this.getJedis();
			String returnValue = jedis.set(key, value);
			return returnValue;
		}
		
		//redis中 添加多个String数据类型
		public String addMultikeys(String[] keysValues) {
			Jedis jedis = this.getJedis();
			String returnVlaue = jedis.mset(keysValues);//mset("k1","1","k2","2");
			jedis.close();
			return returnVlaue;
		}
		
		//redis中 hash数据类型添加
		public Long addHashKey(String hashkey,String fieldkey,String fieldValue) {
			Jedis jedis = this.getJedis();
			
			//hset hashkey fieldkey fieldvalue
			Long returnValue = jedis.hset(hashkey, fieldkey, fieldValue);
			jedis.close();
			return returnValue;
		}
		
		//redis中 存储一个hash key几多个fieldKey与fieldValue
		public Long addHashKeyMultiFieldKey(String hashkey,Map<String, String> fieldKeyValues) {
			Jedis jedis = this.getJedis();
		
			Long returnValue = jedis.hset(hashkey, fieldKeyValues);
			jedis.close();
			return returnValue;
		}
		
		//redis中 存储一个hash key 用JAVA map传几多个fieldKey与fieldValue
		public String addHashMap(String hashkey,Map<String, String> fieldKeyValues) {
			Jedis jedis = this.getJedis();
			String values = jedis.hmset(hashkey,fieldKeyValues);
			jedis.close();
			return values;
		}
		
		//redis中储存List数据 
		public Long addredisList(String listKey,String[] values) {
			Jedis jedis = this.getJedis();
			
			//lpush listKey value1,value2...valuen
			Long returnValues = jedis.lpush(listKey, values);
			jedis.close();
			return returnValues;
		}
		
		//redis存储set数据
		public Long addredisSet(String setKey,String[] setValues) {
			Jedis jedis = this.getJedis();
			//sadd setkey value1,value2....valuen
			Long returnValue = jedis.sadd(setKey,setValues);
			jedis.close();
			return returnValue;
		}
		
		//redis存储zset数据
		public Long addrediszset(String zsetKey,Map<String, Double> values) {
			Jedis jedis = this.getJedis();
			
			//zadd zsetkey score1 value1 score2 value2.....
			Long returnvalues = jedis.zadd(zsetKey, values);
			jedis.close();
			return returnvalues;
			
		}
		
	
		
		//读取一个hash数据值
		public List<String> getUserHash(String hashKey,String[] fieldKeys) {
			Jedis jedis = this.getJedis();
			List<String> list = jedis.hmget(hashKey, fieldKeys);
			jedis.close();
			return list;
		}
		
		//读取一个List数据值
		public List<String> getMyList(String listKey,long start,long stop) {
			Jedis jedis = this.getJedis();
			List<String> list = jedis.lrange(listKey, start, stop);
			jedis.close();
			return list;
		}
		
		//读取一个set数据值
		public Set<String> getMyset(String setKey) {
			Jedis jedis = this.getJedis();
			Set<String> set = jedis.smembers(setKey);
			jedis.close();
			return set;
		}
		
		//获取一个zset数据值
		public Set<String> getMyzset(String zsetKey,long start,long stop) {
			Jedis jedis = this.getJedis();
			Set<String> set = jedis.zrange(zsetKey, start, stop);
			jedis.close();
			return set;
		}
		
		
		//过期操作
		public void addKeytexpire(String key) {
			Jedis jedis = this.getJedis();
			if(jedis.exists(key)) {
				jedis.expire(key,300);
			}else {
				System.out.println("-------------->redis数据库不存在，从MySQL数据库查找");
				jedis.set(key, "100");
				jedis.expire(key,300);
			}
			jedis.close();
		}
		
		public void getKeyexpire(String key) {
			Jedis jedis = this.getJedis();
			if(jedis.exists(key)) {
				Long seconds = jedis.ttl(key);
				if(seconds == -2) {
					System.out.println("该用户已过期！！！");
				}else {
					if(seconds < 60) {
						System.out.println("该用户还剩"+seconds+"秒！");
					}else {
						System.out.println("该用户还剩"+TimeUnit.SECONDS.toMinutes(seconds)+"分钟！");
					}
					
				}
			}else {
				System.out.println("该用户不存在缓存中!!!");
			}
			jedis.close();
		}
		
		//redis单线程事务处理
		public void addStringkeyTransaction() {
			Jedis jedis = this.getJedis();
			Transaction tx = jedis.multi();
			tx.mset("t1","1","t2","2","t3","3");
			tx.exec();
			jedis.close();
			//return value;
		}
		
		//多线线程事务操作
		public List<Object> addStringKeyManyThread() {
			
			Jedis jedis = this.getJedis();
			
			List<Object> values = null;
			
			int count = 0;
			
			while(values == null && count <= 10) {
				
				jedis.watch("t1","t2","t3");
				Transaction tx = jedis.multi();				
				System.out.println("事务开始..................");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				/*
				jedis.set("t1", "10");
				jedis.set("t2", "20");
				jedis.set("t3", "30");*/
				tx.mset("t1","10","t2","20","t3","30");
				
				System.out.println("线程睡眠结束....................");
				values = tx.exec();
				System.out.println("事务结束....................");
				count++;
				
			}
			jedis.close();
			return values;
		}
		

		//获取一个Jedis客户端连接
		private Jedis getJedis() {
			JedisUtil jeditsUtil = new JedisUtil();
			return jeditsUtil.getJedis();
		}
}
