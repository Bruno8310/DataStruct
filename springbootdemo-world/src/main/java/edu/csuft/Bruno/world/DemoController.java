package edu.csuft.Bruno.world;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * RESTful 风格的接口
 * 
 * 
 * @author Bruno
 *
 */

// 一个资源提供一套这样的接口
@RequestMapping("/api/d")
@RestController
public class DemoController {

	@GetMapping()
	public String a() {
		return "GET ALL";
	}
	
	
	@GetMapping("/{id}")
	public String a1(@PathVariable int id) {
		return "GET ONE" + id;
	}
	
	@PostMapping()
	public String b() {
		return "POST";
	}
	
	@PutMapping("/{id}")
	public String c(@PathVariable int id) {
		return "PUT" + id;
	}
	
	@DeleteMapping("")
	public String d() {
		return "DELETE";
	}
}
