package edu.csuft.Bruno.test;

/**
 * Test3
 */
public class Test1 extends A {

	public Test1() {
		System.out.println("派生类构造函数");
	}

	{
		System.out.println("派生类成员构造函数");
	}

	static {
		System.out.println("派生类静态块");
	}

	public void info() {
		System.out.println("派生类成员函数info");
		String string = new String();
	}

	public static void main(String[] args) {
		A a = new Test1();
		a.info();
		System.out.println("------------------");
		a = new Test1();
		a.info();
	}
}

class A {
	public A() {
		System.out.println("基类构造函数");
	}

	{
		System.out.println("基类成员构造函数");
	}

	static {
		System.out.println("基类静态块");
	}

	public void info() {
		System.out.println("基类成员函数info");
	}
}