package edu.csuft.Bruno.desgin;
/**
 * 工厂模式
 * 
 * @author Bruno
 *
 */
public class Factory {

	// 访问修饰符：私有或者包可见
	private Factory() {
		
	}
	
	/**
	 * 静态工厂
	 * 
	 * @return
	 */
	public static Factory getInstance() {
		return new Factory();
	}
	
}
