package com.newer.Tea.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.Tea.Mapper.PriceListMapper;
import com.newer.Tea.pojo.PriceList;

@RestController
@RequestMapping("/priceList")
public class PriceListController {
	
	@Autowired
	PriceListMapper mapper;
	
	@GetMapping()
	public List<PriceList> findPriceList() {
		return mapper.findPriceList();
	} 

}
