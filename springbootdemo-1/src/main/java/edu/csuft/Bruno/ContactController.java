package edu.csuft.Bruno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API 接口
 * 
 * @author Bruno
 *
 */
@RestController
@RequestMapping("/api/vi/contact")
public class ContactController {

	@GetMapping("/data")
	public List<Contact> list() {
		
		// 可以从数据库中查询获取数据
		ArrayList<Contact> list = new ArrayList<>();
		list.add(new Contact(1, "alice", "12346789"));
		list.add(new Contact(2, "bob", "234324"));
		list.add(new Contact(3, "jack", "6789"));
		list.add(new Contact(4, "bruno", "46789"));
		list.add(new Contact(5, "franman", "234289"));

		return list;
	}

}
