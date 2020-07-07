package edu.csuft.Bruno;

import java.net.http.HttpResponse;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.resource.HttpResource;

/**
 * 用户控制器
 * 
 * @author Bruno
 *
 */
@Controller
public class UserController {

	@GetMapping("/loginout")
	public String loginout(HttpSession session) {

		// 会话失效、过期
		session.invalidate();
		// 重定向
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(String username, String password, HttpSession session, HttpServletResponse response) {

		HashMap<String, String> map = new HashMap<>();
		map.put("alicy", "123456");
		map.put("alicy1", "123456");
		map.put("alicy2", "123456");
		map.put("alicy3", "123456");
		// 业务逻辑
		if (map.containsKey(username) && map.get(username).equals(password)) {
			// 成功,加载用户的基本信息
			// 存入会话或者cookie
			session.setAttribute("username", username);
			session.setAttribute("userInfo", username + "更多的用户信息");
			// 设置cookie
			Cookie cookie = new Cookie("uid", username);
			cookie.setMaxAge(60 * 60 * 24);
			Cookie cookie2 = new Cookie("login", "true");
			cookie2.setMaxAge(60 * 60 * 24);
			// 将cookie添加到响应头中
			response.addCookie(cookie);
			response.addCookie(cookie2);
			return "redirect:cart";
		} else {
			// 失败
			Cookie cookie2 = new Cookie("login", "true");
			cookie2.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie2);
			// 重定向到错误页面
			return "redirect:reg";
		}
	}
}
