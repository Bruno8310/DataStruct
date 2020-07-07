package edu.csuft.Bruno.desgin;

public class Singleton2 {

	//私有，避免外界的直接调用
	private Singleton2() {
		
	}
	
	//提前准备，类加载的阶段创建实例
	static Singleton2 singleton2 = new Singleton2();
	
	//触发获取对象
	public static Singleton2 getSingleton2() {
		return singleton2;
	}
	
}
