package edu.csuft.Bruno.desgin;

import java.util.Observable;

/**
 * 观察者模式----MVVM---Model---View---ViewModel
 * 
 * 可观测的主题
 * 
 * @author Bruno
 *
 */
public class Model extends Observable{

	// 模型中有一个数据
	int value;
	
	/**
	 * 通过方法去修改模型的数据或者状态
	 * @param value 模型中的值
	 */
	public void setValue(int value) {
		this.value = value;
		// 通知有两种形式
//		notifyObservers();
		// 
		setChanged();
		notifyObservers(value);
	}
}
