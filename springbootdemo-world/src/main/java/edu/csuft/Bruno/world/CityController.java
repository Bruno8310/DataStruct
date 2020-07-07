package edu.csuft.Bruno.world;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// RESTful API/URl
@RestController
@RequestMapping("/api/city")
public class CityController {

	// 依赖注入
	@Autowired
	CityMapper cityMapper;

	@GetMapping
	public HashMap<String, Object> Page(@RequestParam(name = "s") int start) {

		HashMap<String, Object> map = new HashMap<>();
		// 初始化为10条
		int size = 10;

		// cityList: 集合数据
		map.put("cityList", cityMapper.list(size, start));

		// 查询得到总数据条数
		int pagecount1 = cityMapper.count();

		// 转换成小数再强制向上取整
		int pagecount2 = (int) Math.ceil((pagecount1 * 1.0) / size);

		map.put("pagecount2", pagecount2);

		// currentpage: 当前第几页
		int currentpage = start / size + 1;
		
		map.put("currentpage", currentpage);
		
		return map;
	}

	// 请求参数 /api/city?n=10&s=0
	// 路径参数 /api/city/10
//	@GetMapping("/{n}/{s}")
//	public List<City> show(@PathVariable(name = "n") int size,
//						   @PathVariable(name = "s") int start) {
//		return cityMapper.list(size, start);
//	}

	// /api/city?n=10&s=10
//	@GetMapping
//	public List<City> show1(@RequestParam(name = "n", defaultValue = "10", required = false) int size,
//							@RequestParam(name = "s", defaultValue = "10", required = false) int start) {
//		return cityMapper.list(size, start);
//		
//	}
//	
//	@GetMapping("/{id}")
//	public City show2(@PathVariable int id) {
//		return cityMapper.load(id);
//	}

}
