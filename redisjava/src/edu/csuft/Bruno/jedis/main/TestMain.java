package edu.csuft.Bruno.jedis.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import edu.csuft.Bruno.jedis.dao.RedisDao;

/**
 * 测试
 * 
 * @author Bruno
 *
 */
public class TestMain {

	// 生成RedisDao的实例
	private static RedisDao redisDao = new RedisDao();

	public static void main(String[] args) {

//		TestMain.testJoin();
//		TestMain.testaddStringKey();
//		TestMain.testaddHashKey();
//		TestMain.testaddHashKeyMultiFieldKey();
//		TestMain.testaddHashMap();
//		TestMain.testaddMultikeys();
//		TestMain.testaddredisList();
//		TestMain.testaddredisSet();
//		TestMain.testaddrediszset();
//		TestMain.testgetMyList();
		TestMain.testaddStringKeyManyThread();
	}

	public static void testJoin() {
		byte[] bytes = redisDao.testJoin();
		System.out.println(new String(bytes));
	}

	public static void testaddStringKey() {
		redisDao.addStringKey("k1", "Hello");
	}

	public static void testaddMultikeys() {
		String[] keyvalues = new String[] { "k2", "2", "k3", "3" };
		String message = redisDao.addMultikeys(keyvalues);
		System.out.println("--------------------->" + message);
	}

	public static void testaddHashKey() {
		Long value = redisDao.addHashKey("user", "uid", "007");
		System.out.println("------------------>" + value);

	}

	public static void testaddHashKeyMultiFieldKey() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("uname", "小李");
		// map.put("age","23");

		Long value = redisDao.addHashKeyMultiFieldKey("user", map);
		System.out.println("----------------->" + value);

	}

	public static void testaddHashMap() {

		Map<String, String> map = new HashMap<String, String>();

		map.put("age", "23");
		map.put("salary", "1500");

		redisDao.addHashMap("user", map);
	}

	public static void testaddredisList() {
		Long v = redisDao.addredisList("myList", new String[] { "m", "y", "l" });
		System.out.println("---------------->" + v);
	}

	public static void testaddredisSet() {
		Long returnValue = redisDao.addredisSet("myset", new String[] { "a", "a", "b", "c" });
		System.out.println("-------------------->" + returnValue);
	}

	public static void testaddrediszset() {

		Map<String, Double> map = new HashMap<String, Double>();
		map.put("小李", 500.00);
		map.put("小张", 123.54);
		map.put("小何", 300.00);

		Long returnValue = redisDao.addrediszset("myzset", map);
		System.out.println("------------------>" + returnValue);
	}

	public static void testgetUserHash() {
		RedisDao redisDao = new RedisDao();
		List<String> list = redisDao.getUserHash("user", new String[] { "uid", "uname", "salary", "age" });
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("-------------->t:" + t);

			}

		});
	}

	public static void testgetMyList() {
		RedisDao redisDao = new RedisDao();
		List<String> list = redisDao.getMyList("myList", 0, -1);
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("-------------->t:" + t);

			}

		});

	}

	public static void testgetMyset() {
		RedisDao redisDao = new RedisDao();
		Set<String> set = redisDao.getMyset("myset");
		set.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("-------------->t:" + t);
			}

		});
	}

	public static void testgetMyzset() {
		RedisDao redisDao = new RedisDao();
		Set<String> set = redisDao.getMyzset("myzset", 0, -1);
		set.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("-------------->t:" + t);
			}

		});
	}
	
	public static void testaddStringKeyManyThread() {
		redisDao.addStringKeyManyThread();
		
	}
	
}
