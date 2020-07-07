package com.newer.Tea.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newer.Tea.Mapper.GoodsMapper;
import com.newer.Tea.pojo.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	GoodsMapper mapper;

	@GetMapping("/{classify}")
	public List<Goods> findGoods(@PathVariable String classify) {
		return mapper.findGoods(classify);
	}

	@PostMapping("/insert")
	public String updateGoods(MultipartFile file, Goods goods) throws IllegalStateException, IOException {

		System.out.println("hahahah");
		// 随机生成一个图片名
		String fileName = UUID.randomUUID().toString().replace("-", "")
				+ file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));

		// 1.把图片保存到本地图片服务器位置
		file.transferTo(new File("" + fileName));

		// 2.把保存到数据库中图片的位置设置给goods
		goods.setPicture("" + fileName);

		System.out.println(goods);
		mapper.updateGoods(goods);
		return "update";
	}

}
