package edu.csuft.Bruno;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 购物车控制器
 * @author Bruno
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	/**
	 * GET /cart
	 * 
	 * 
	 * @return 视图名(修改了前缀和后缀 ---取jsp路径查找---返回jsp页面)
	 */
	@GetMapping
	public String home(HttpSession session, Model model) {
		
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		// 存储购物车中的商品列表		
		ArrayList<Goods> goodsList = new ArrayList<>();
		
		// 总价格
		int total = 0;
		for (Integer pid: cart.pidList()) {
			// 获得商品
			Goods goods = Db.findGoods(pid);
			// goodsList.add(goods);
			// 获得数量
			int num = cart.pidNum(pid);
			// 获得总价
			total += (goods.getPrice() * num);
		}
		
		// Model中的数据只在请求作用域中
		model.addAttribute("total", total);
		model.addAttribute("goodsList", goodsList);
		// 请求转发
		return "cart";
	}
	
	/**
	 * POST访问cart
	 * @param pid
	 * @return
	 */
	@PostMapping
	public String add(int pid, HttpSession session) {
		
		System.out.println(pid);
		// 加入购物车
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		cart.add(pid);
		// 返回视图
		// 1.去购物车
		// 2.回到原页面
		return "redirect:/";
	}
}