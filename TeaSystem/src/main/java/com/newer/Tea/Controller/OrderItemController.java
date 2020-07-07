package com.newer.Tea.Controller;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.Tea.Mapper.OrderItemMapper;
import com.newer.Tea.pojo.OrderItem;


@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

	@Autowired
	OrderItemMapper mapper;
	
	@GetMapping("/select/{orderId}")
	public List<OrderItem> findOrderItems(@PathVariable int orderId) {
		return mapper.findOrderItems(orderId);
	}
	
	@PostMapping("/insert/{phone}")
	public String saveOrderItem(@PathVariable String phone) {
		mapper.save(phone);
		return "insertOrderItem";
	}
	
}
