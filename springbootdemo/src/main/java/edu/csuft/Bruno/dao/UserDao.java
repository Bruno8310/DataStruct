package edu.csuft.Bruno.dao;

import java.util.List;

import edu.csuft.Bruno.entity.User;

public interface UserDao {

	/**
	 * 
	 * @return 查询所有用户
	 */
	public List<User> selectAllUsers();
}
