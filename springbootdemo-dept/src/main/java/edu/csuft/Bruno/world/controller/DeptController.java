package edu.csuft.Bruno.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.csuft.Bruno.world.mapper.DeptMapper;
import edu.csuft.Bruno.world.pojo.Dept;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DeptMapper deptMapper;
	@GetMapping("/{id}")
	public Dept findById(@PathVariable int id) {
		return deptMapper.load(id);
	}
	
	@PostMapping
	public int create(Dept dept) {
		
		int n = deptMapper.save(dept);
		
		int id = dept.getId();
		
		return id;
	}
}
