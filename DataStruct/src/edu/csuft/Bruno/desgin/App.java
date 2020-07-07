package edu.csuft.Bruno.desgin;

import javax.security.auth.Subject;

public class App {

	public static void main(String[] args) {
		
		//全局作用域
		/*
		 * Singleton singleton1 = Singleton.getInstance(); Singleton singleton2 =
		 * Singleton.getInstance(); Singleton singleton3 = Singleton.getInstance();
		 * Singleton singleton4 = Singleton.getInstance();
		 * System.out.println(singleton1); System.out.println(singleton2);
		 * System.out.println(singleton3);
		 */
		// 数据/主题
		Model model = new Model();
		Subject subject = new Subject();
		
		// 观察者/订阅方		
		View view = new View();
		CLIView cliView = new CLIView();
		Other other = new Other();
		// view是model的观察者
		model.addObserver(view);
		
		// cliView是model的观察者
		model.addObserver(cliView);
		
		// subject.addObserver(other);
		// 数据/注意的改变，所有的订阅者都会收到,主动回调观察者
		model.setValue(99);;
	}
}
