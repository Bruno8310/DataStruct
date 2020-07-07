package edu.csuft.Bruno.world;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	// @RequestMapping("/")
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	// URL中路径固定
	@GetMapping("/user")
	public String user() {
		return "user.html";
	}

	// URL中的路径参数化----参数值可以拿到----参数变量默认都是字符串(但也可以执行类型的自动转换)
//	@GetMapping("/user/{name}")
//	public String userPerson(@PathVariable int name) {
//		return "";
//	}

	// 该注解作用----不返回视图，返回数据(response body)
	@ResponseBody
	@GetMapping("/user/{name}")
	public String userPerson(@PathVariable String name) {
		String msg = String.format("你好,%s", name);

		// TODO 加载路径参数相关的信息，然后再把相关信息返回

		return msg;
	}

	@GetMapping("/staff")
	// @RequestParam获取请求参数，参数名需要一致，不然取不到---采取取别名进行转换
	public String c(@RequestParam("user") String user, @RequestParam("age") int age, @RequestParam("gender") String gender) {
		
		System.out.printf("user:%s\n", user);
		System.out.printf("age:%d\n", age);
		System.out.printf("gender:%s\n", gender);
		
		return "";
	}
	
	@ResponseBody
	@PostMapping("/staff")
	public Staff d(Staff staff) {
		// HTTP的请求参数被自动封装成了一个对象，字段名互相匹配
		System.out.println(staff);	
		
		return staff;
	}
}
