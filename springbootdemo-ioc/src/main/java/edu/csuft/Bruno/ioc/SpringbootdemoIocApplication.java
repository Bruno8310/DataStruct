package edu.csuft.Bruno.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * IOC:控制反转/依赖注入 Spring 是一个IOC容器，用来管理组件的生命周期 组件(pojo 普通的Java
 * Bean):符合特定规则(继承某些类、实现接口)的类或者是类的集合
 * 
 * 
 * 
 * @author Bruno
 *
 */
@SpringBootApplication
public class SpringbootdemoIocApplication {

	// 程序入口和起点
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoIocApplication.class, args);
	}

	// @Bean
	public CommandLineRunner m1(ApplicationContext context, BeanFactory factory) {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				System.out.println("m1");

				// 获得的是同一个对象---单例模式---构造方法私有，定义一个静态的成员方法创建对象

				// 可以说明 Spring可以创建对象、初始化、销毁前资源释放

				// 组件的作用域 有 单例、原型、请求、会话
				Dog d1 = context.getBean(Dog.class);
				Dog d2 = context.getBean(Dog.class);

				System.out.println(d1);
				System.out.println(d2);

				System.out.println(factory.getBean(Dog.class));
			}
		};
	}

	@Bean
	public CommandLineRunner m2(ApplicationContext context) {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Dog d1 = context.getBean(Dog.class);
				// d1.eat();
			}
		};
	}

}
