package hello.tea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.tea.mapper.OrderMapper;
import hello.tea.pojo.Order;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderMapper mapper;
	
	@GetMapping("/{phone}")
	public List<Order> findGoods(@PathVariable String phone) {
		return mapper.findOrder(phone);
	}
	
	@PostMapping
	public String save(@RequestBody Order order) {
		mapper.save(order);
		return "insertOrder";
	}

}
