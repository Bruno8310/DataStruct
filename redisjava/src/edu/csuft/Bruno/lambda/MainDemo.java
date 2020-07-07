package edu.csuft.Bruno.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试lamdba表达式
 * @author Bruno
 *
 */
public class MainDemo {

	public static void main(String[] args) {

		Demo demo =	() -> {
			System.out.println("Hello Lambda!");

				};
		demo.PrintTest();
		System.out.println("====================");

		Thread thread = new Thread(
		() -> {
			System.out.println("Hello Thread");
		});

		thread.start();
		System.out.println("====================");

		List<String> list = new ArrayList<>();
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		list.add("DDD");
		list.add("EEE");		
		list.forEach((String str) -> {
				System.out.println(str);
		});
		System.out.println("====================");
		
		//当只有一条打印语句时，可改写成以下
		List<String> list1 = new ArrayList<>();
		list1.add("AAAA");
		list1.add("BBBB");
		list1.add("CCCC");
		list1.add("DDDD");
		list1.add("EEEE");
		long time = System.currentTimeMillis();
		list1.forEach(System.out::println);
		System.out.println(System.currentTimeMillis() - time);
		
		long time1 = System.currentTimeMillis();
		Stream<String> stream = list1.stream().parallel();
		stream.forEach(System.out::println);
		System.out.println(System.currentTimeMillis() - time1);
	}
}
