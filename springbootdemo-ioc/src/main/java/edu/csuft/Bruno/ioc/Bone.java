package edu.csuft.Bruno.ioc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bone")
@Lazy
public class Bone implements Food {

	public Bone() {
		System.out.println("Bone()构造方法");
	}
}
