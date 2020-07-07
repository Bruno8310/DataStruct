package edu.csuft.Bruno.desgin;

import java.util.Observable;
import java.util.Observer;

public class Other implements Observer {

	// 观察者需要重写的方法
	@Override
	public void update(Observable o, Object arg) {
		
		if (o instanceof Model) {
			System.out.println("Other获得Model中的 " + arg);
		} if (o instanceof Subject) {
			// 得到Subject的对象
			Subject subject = (Subject)o;
			System.out.println("Other 获得Subject" + subject.mood);
		}
		
	}

}
