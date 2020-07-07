package edu.csuft.Bruno.stack;

import java.util.Arrays;
import java.util.Queue;

import javax.print.attribute.Size2DSyntax;

public class Test1 {

	public static void main(String[] args) {
		//测试数组实现的队列
		/*ArrayQueue<String> aQueue = new ArrayQueue<>();
		System.out.println(aQueue.isEmpty());
		System.out.println(aQueue.size());
		aQueue.add("AAA");
		aQueue.add("BBB");
		aQueue.add("CCC");
		aQueue.add("DDD");
		aQueue.add("EEE");
		System.out.println(Arrays.toString(aQueue.data));
		System.out.println(aQueue.size());
		System.out.println(aQueue.poll());
		System.out.println(aQueue.poll());
		System.out.println(aQueue.poll());
		System.out.println(Arrays.toString(aQueue.data));
		System.out.println(aQueue.size());
		System.out.println(aQueue.isEmpty());
		System.out.println("=============================");*/
		//测试基于链表实现的队列
		LinkeQueue<String> lQueue = new LinkeQueue<>();
		System.out.println(lQueue.isEmpty());
		System.out.println(lQueue.size());
		lQueue.add("A");
		lQueue.add("B");
		lQueue.add("C");
		lQueue.add("D");
		lQueue.add("D");
		
		System.out.println(lQueue.size());
		System.out.println(lQueue.poll());
		for (int i = 0; i < lQueue.size; i++) {
			System.out.println(lQueue.item(i).data);
		}
		
	}
}
