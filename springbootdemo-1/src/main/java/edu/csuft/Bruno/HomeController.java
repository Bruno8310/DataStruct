package edu.csuft.Bruno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * MVC: 控制器组件
 *     请求分发、路由 * 
 * 
 * @author Bruno
 *
 */
@Controller
public class HomeController {
	
	// 使用http协议中get方法发送请求，访问 / 路径
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin.html";
	}
	
	// 请求映射 是所有映射的父类型
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public String user() {
		return "user.html";
	}
	
}
