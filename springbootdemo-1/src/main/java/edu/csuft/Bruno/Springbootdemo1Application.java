package edu.csuft.Bruno;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.csuft.Bruno.component.Com;


@SpringBootApplication
public class Springbootdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo1Application.class, args);
	}
	
	/**
	 * spring的核心
	 * spring 
	 * spring core 核心(定义的基本的接口)
	 * spring bena 组件 (定义的Bean的工厂---BeanFactory)
	 * spring context 上下文 (资源相关)
	 * 
	 * @return
	 */	
	// spring boot CLI
	@Bean
	public CommandLineRunner a(BeanFactory factory, ApplicationContext aplApplicationContext) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.out.println(factory);
			}
		};
	}
	
	@Bean
	public CommandLineRunner b(BeanFactory factory) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.out.println(factory);
			}
		};
	}
	
	@Bean
	public CommandLineRunner c(BeanFactory factory, ApplicationContext applicationContext) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				//第一种方式----想要获得Com对象
				Com c = new Com();
				c.work();
				
				//第二种方式-----交给Sping容器创建,可以利用BeanFactory创建
				Com c2 = factory.getBean(Com.class);
				c2.work();
				// c2,c3的散列值相同,c1不同
				Com c3 = factory.getBean(Com.class);
				c3.work();
				// 也可以从上下文创建Bean
				Com c4 = applicationContext.getBean(Com.class);
				// c2 c3 c4 的散列值都相同---都是同一个对象--单例模式
				
			}
		};
	}
	
	

}
