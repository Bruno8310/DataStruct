package edu.csuft.Bruno.desgin;
/**
 * 设计模式：解决特定问题可以用来复用的方法
 * 
 * 1)创建对象：单例、工厂、Builder
 * @author Bruno
 *单例模式：类是一个模板，实例化出多个对象，某些资源在特定的系统中是唯一
 *	实现：构造方法私有，提供一个静态的方法获得唯一实例
 */
public class Singleton {

	//类变量(只有一份)
	static Singleton instance;
	
	
	private Singleton() {
		
		//资源的初始化
	}
	
	/**
	 * 触发方法时，生成对象
	 * 从类方法获得唯一实例
	 * 
	 * @return 实例
	 */
	public synchronized static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	
}
