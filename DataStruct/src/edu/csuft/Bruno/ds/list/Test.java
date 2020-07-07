package edu.csuft.Bruno.ds.list;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		//ArrayList<Object> arrayList = new ArrayList<>();
		
		
		LineList<String> list = new LineList<>();
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		System.out.println(list.size());
		System.out.println(list.remove());
		System.out.println(list.remove(1));
	}
}
