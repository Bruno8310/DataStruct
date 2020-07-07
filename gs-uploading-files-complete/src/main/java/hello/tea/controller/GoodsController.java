package hello.tea.controller;

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

import hello.tea.mapper.GoodsMapper;
import hello.tea.pojo.Goods;


@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	GoodsMapper mapper;

	@GetMapping("/{classify}")
	public List<Goods> findGoods(@PathVariable String classify) {
		return mapper.findGoods(classify);
	}


}
