package edu.csuft.Bruno.desgin;

import java.util.Observable;
import java.util.Observer;

/**
 * 模型的观察者
 * 主题的订阅方
 * 
 * @author Bruno
 *
 */
public class View implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("view" + arg);
	}

	
}
