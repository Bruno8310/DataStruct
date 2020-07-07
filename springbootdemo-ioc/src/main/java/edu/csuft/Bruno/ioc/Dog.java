package edu.csuft.Bruno.ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 普通的类
 * 普通的方法只有调用之后才会执行
 * 
 * 容器回调(托管) callback(钩子函数)
 * @author Bruno 组件交给容器去管理
 */
@Component
// 作用域---把单例改成原型
@Scope("prototype")
public class Dog {

	// 依赖---要用到其他的对象或者属性参数等
	// 自动装配 (由容器负责依赖资源的注入)
	@Autowired
	@Qualifier("bone")
	// @Lazy
	Food food;
	
	public void eat() {
		System.out.println("eat:" + food);
	}
	
	public Dog() {
		System.out.println("Dog(的构造方法)");
	}
	
	// 构造方法执行之后
	@PostConstruct
	public void a() {
		System.out.println("方法a");
	}
	// 销毁前
	@PreDestroy
	public void b() {
		System.out.println("方法b");
	}
	
	public void print() {
		System.out.println("普通方法");
	}
	

}
