package edu.csuft.Bruno.ioc.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 控制器
 * @author Bruno
 *
 */
// 提供请求的分发和路由
@Controller
public class HomeController {

	// 依赖业务逻辑
	@Autowired
	AccountService accountService;
	
	
}
