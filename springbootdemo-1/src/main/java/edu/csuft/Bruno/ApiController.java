package edu.csuft.Bruno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// RESTful 架构风格的API接口
// REST-----资源呈现状态迁移
// @Controller + @ResponseBody
@RestController
public class ApiController {

	@GetMapping("/info")
	public String a() {
		return "RESTful API";
	}
	
	@GetMapping("/data")
	public HashMap<String , Object> data() {
		HashMap<String,Object> map = new HashMap<>();
		map.put("name", "小丽");
		map.put("age", 20);
		map.put("专业", "计算机科学");
		return map;
		
	}
	
	@GetMapping("/question")
	public List<Question> Q() {
		
		List<Question> arrayList = new ArrayList<>();
		
		Question question = new Question();
		Question question1 = new Question();
		
		question.setId(1);
		question.setSubject("最好的程序设计语言?");
		question.setItem(new String[] {"Go", "Kotlin", "PHP"});
		question.setAnswer("D");
		
		question1.setId(1);
		question1.setSubject("最长的河流？");
		question1.setItem(new String[] {"浏阳河", "长江", "黄河"});
		question1.setAnswer("A");
		
		arrayList.add(question);
		arrayList.add(question1);
		return arrayList;
	}
 }
