package com.name.app;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP的请求处理器---HTTP Request Handler
   *   表单提交页面地址栏会跳转，可以进行重定向，该方式所发送的请求包含静态资源，
   *   开销很大，通过脚本提交不会跳转还在原页面，无法实现重定向，可以设置返回的状态码信息，发送的请求相对较少，开销小
   *   
 * @author Bruno
 *
 */
@RestController
public class StudentController {

	@Autowired
	StudentMapper studentMapper;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/student")
	public List<Student> list() {
		return studentMapper.findAll();
	}

	/**
	 * XHR: 异步HTTP请求
	 * 
	 * @RequestBody: HTTP以post方式将数据以JSON的格式发过来,进行解析,然后再封装成一个实体类中
	 * 没有RequestBody默认的是表单数据(html中的form)提交---自动封装一个对象, 页面会跳转改变(URL会改变，需要做重定向选择)
	 * @param s
	 * @return 状态码
	 */
	@PostMapping("/student")
	public ResponseEntity<HttpStatus> create(Student s) {
		studentMapper.save(s);
		// 也可以返回一个响应的状态码----return ResponseEntity<HttpStatus>
		return new ResponseEntity<> (HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/student/{id}")
	public String remove(@PathVariable int id) {
		studentMapper.remove(id);
		return "remove successfully";
	}
	
	/**
	 * 
	 * @param id url中的路径
	 * @return 自定义的状态
	 */
	@DeleteMapping("/student/{id}")
	public HashMap<String, String> remove1(@PathVariable int id) {
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("status", "OK");
		hashMap.put("code", 200);
		return null;
	}
}
