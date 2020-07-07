package edu.csuft.Bruno.test;

public class Test2 {

	public static void main(String[] args) {
		
		Integer e = 127;
		
		Integer f = 127;
		
		Integer a = 128;
		
		Integer b = new Integer(128);
		
		Integer c = Integer.valueOf(128);
		
		int d = 128;
		
		System.out.println(a==b); // false
		
		System.out.println(a==c); // false
		
		System.out.println(a==d); // true
		
		System.out.println(b==c); // false
		 
		System.out.println(b==d); // true
		
		System.out.println(d==c); // true
		
		System.out.println(e==f); // true
	}
}
