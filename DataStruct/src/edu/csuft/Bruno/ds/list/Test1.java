package edu.csuft.Bruno.ds.list;

public class Test1 {

	public static void main(String[] args) {
		LinkeList<String> list = new LinkeList<>();
		list.add("a");
		list.add("c");
		list.add("b");
		list.add("d");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.item(i).data);
		}
		System.out.println("================");
		list.add(2, "AAAA");
		System.out.println(list.remove(4));
		System.out.println("================");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.item(i).data);
		}
	}
}
