package edu.csuft.Bruno.desgin;

import java.util.Observable;

public class Subject extends Observable {

	// 主题中的数据
	String mood;
	
	int n;
	
	public void setMood() {
		this.mood = mood;
		
		
		// 设置改变状态
		setChanged();
		// 通知观察者，不传数据，主动获取数据
		// 继承父类的方法，遍历观察者列表，回调每个观察者的update()方法
		notifyObservers();
	}
	
	public void setStatus(int n) {
		this.n = n;
		
		
	}
}
