package edu.csuft.Bruno.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.csuft.Bruno.model.Person;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		List<Person> list = new ArrayList<>();
		
		
		Map<String, String> map1 = new HashMap<>();
		
		Map<String, Person> map2 = new HashMap<>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		map1.put("name1", "zhangsan");
		map1.put("name2", "lisi");
		map1.put("name3", "wangwu");
		
		map2.put("p1", p1);
		map2.put("p2", p2);
		map2.put("p3", p3);
		
		System.out.println(map2.get(p1));
		
//		Set<String> keys = map2.keySet();
//		
//		for (String key : keys) {
//			System.out.println(key);
//		}
		
		System.out.println(list);
		
		System.out.println(map2);
	}
}
