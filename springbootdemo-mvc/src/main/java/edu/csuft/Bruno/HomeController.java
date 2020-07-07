package edu.csuft.Bruno;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

// HTTP请求的处理器
@Controller
public class HomeController {

	// 视图
	 ViewResolver viewr;
	 
	 View view;
	 
	 org.springframework.web.servlet.mvc.Controller cc;
	 
	 // 请求控制器---拦截所有请求并放入控制器中
	 DispatcherServlet dispatchersevlet;
	
	 HandlerMapping hm;
	 
	 
	// 返回的是View的名字--去找这个同名的文件
	// URL
	@GetMapping({"/", "/hello"})
	public String hello(Model m) {
		
		// Model--视图加载或应用模型:在服务器端进行渲染/模板引擎
		m.addAttribute("time", new Date());	
		return "hello.html";
	}
	
	// 返回的是View的名字--去找这个同名的文件
	// URL
	@GetMapping("/bye")
	public String bye() {
		return "redirect:user";
	}
}
