package edu.csuft.Bruno;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping("/")
	public String printHelloWorld() {
		return "Hello world!";
	}

}
