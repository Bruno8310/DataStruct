package edu.csuft.Bruno.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Component这个注解交给容器去处理
 * @author Bruno
 *
 * 由容器管理，默认单例模式(每次返回全局唯一的，每次去取都是同一个)，
 * 可以修改作用域，还有包括原型(每次返回新创建的)、请求(web)、会话(web)
 *
 *
 * 指定组件的名字约束  @Qualifier
 * 指定组件的首选    @Primary
 *
 */
@Component
@Scope("PROTOTYPE")
public class Com {

	// 全局唯一(单例) 
	@Autowired
	BeanFactory factory;
	
	public Com() {
		
	}
	
	public void work() {
		System.out.println(this+ "work in BeanFactory: " + factory);
	}
	
	
	// 当类中有一些普通的方法,当需要显示地调用，可以加一些注解
	// 构造后调用----称为回调函数，容器来做和执行，特定的逻辑处理交由程序员实现
	@PostConstruct
	public void init() {
		// callback
	}
	// 销毁前调用---称为回调函数，容器来做和执行，特定的逻辑交由程序员实现
	@PreDestroy
	public void destory() {
		// callback
	}
}
