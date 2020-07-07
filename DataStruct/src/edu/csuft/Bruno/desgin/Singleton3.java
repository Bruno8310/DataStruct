package edu.csuft.Bruno.desgin;

/**
 * 方案三：crazy bob (bob lee)---谷歌员工
 * 
 * @author Bruno
 * 
 * 在调用getInstance方法时，才加载SingletonHolder类，再调用Singleton3的构造方法，实例化对象，达到懒加载
 *
 */
public class Singleton3 {

	static class SingletonHolder {
		static Singleton3 instance = new Singleton3();
	}

	public static Singleton3 getInstance() {
		return SingletonHolder.instance;
	}
}
