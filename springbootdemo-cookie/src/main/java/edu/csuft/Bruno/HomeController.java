package edu.csuft.Bruno;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(HttpServletResponse response) {
		// 创建cookie
		Cookie c1 = new Cookie("login", "false");
		c1.setMaxAge(60 * 60 * 24 * 365);

		Cookie c2 = new Cookie("duration", "hahahha");
		c2.setMaxAge(60 * 60 * 24);

		Cookie c3 = new Cookie("user", "Bruno");
		c3.setMaxAge(60 * 60 * 24);

		// 发送数据，写入浏览器
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);

		return "hello";
	}

	@GetMapping("/news")
	public String home1(HttpServletRequest request, Model model) {
		// 可以在二级页面对cookie进行逻辑处理---获得所有的cookie
		Cookie[] cookies = request.getCookies();
		// 遍历所有的cookie
		boolean isLogin = false;

		String name = "";

		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("login")) {
					String value = cookies[i].getValue();
					if (value.equals("false")) {
						isLogin = true;
					}
				}
				if (cookies[i].equals("user")) {
					name = cookies[i].getValue();
				}
			}

			if (isLogin) {
				return "redirect:user";
			} else {
				return "a";
			}
		}
		return "a";
	}

	@GetMapping("/teach")
	public String home2() {
		return "b";
	}

	@GetMapping("/others")
	public String home3() {
		return "c";
	}
}
