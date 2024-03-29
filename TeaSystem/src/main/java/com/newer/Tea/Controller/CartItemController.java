package com.newer.Tea.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.Tea.Mapper.CartItemMapper;
import com.newer.Tea.pojo.ShoppingCartItem;

@RestController
@RequestMapping("/cartitem")
public class CartItemController {

	@Autowired
	CartItemMapper mapper;

	@GetMapping("/{phone}")
	public List<ShoppingCartItem> findCartItem(@PathVariable String phone) {
		return mapper.findCartItem(phone);
	}

	@PostMapping
	public String save(@RequestBody ShoppingCartItem shoppingCartItem) {
		mapper.save(shoppingCartItem);
		return "insert";
	}
	
	@PutMapping("/{cartItemId}")
	public String update(@PathVariable int cartItemId, @RequestBody ShoppingCartItem shoppingCartItem) {
		System.out.println(shoppingCartItem.getCartItemId());
		System.out.println(shoppingCartItem.getNumber());
		System.out.println(shoppingCartItem.toString());
		mapper.update(shoppingCartItem);
		return "update";
	}

	@DeleteMapping("/{cartItemId}")
	public String delete(@PathVariable int cartItemId) {
		mapper.delete(cartItemId);
		return "delete";
	}
	
	@DeleteMapping("/deletebyphone/{phone}")
	public String deleteByPhone(@PathVariable String phone) {
		mapper.deleteByPhone(phone);
		return "delete";
	}
}
