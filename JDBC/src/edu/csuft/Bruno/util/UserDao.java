package edu.csuft.Bruno.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.csuft.Bruno.entity.User;

public class UserDao {

	/**
	 * 保存
	 * @param u 
	 */
	public void save(User u) {
		String INSERT_USER = "insert into user(name, phone, birthday) values(?,?,?)";
		
		String INSERT_LOGIN = "insert into login(id, name, password) values(last_insert_id(),?,sha2(?,256)";
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			
			//建立一个数据库的连接(TCP Socket)
			//connection = DbUtil.getConnection();
			
			//从连接创建一个执行语句
			preparedStatement = connection.prepareStatement(INSERT_USER);
			
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getPhone());
			preparedStatement.setDate(3, u.getBirthday());
			preparedStatement.execute();
			
			
			
			preparedStatement = connection.prepareStatement(INSERT_LOGIN);
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getPassword());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * 根据姓名加载用户信息
	 * 
	 * @param name
	 * @return
	 */
	public User load(String name) {
		User user = null;
		
		return user;
	}
}
