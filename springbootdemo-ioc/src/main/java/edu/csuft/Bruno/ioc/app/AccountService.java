package edu.csuft.Bruno.ioc.app;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Bruno
 *
 */
// 业务逻辑
@Service
public class AccountService {

	// 依赖数据访问
	@Autowired
	UserRespository userRespository;
	
	@Resource
	PasswordRespository passwordRespository;
	
	public void login() {}
	
	public void register() {}
	
	public void edit() {}
}
