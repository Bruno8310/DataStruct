package edu.csuft.Bruno.mapper;
/**
 * 注解式接口
 * @author Bruno
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Select;

import edu.csuft.Bruno.entity.User;

public interface UserMapper {

	@Select("select * from user_info")
	public List<User> findAllUsers();
}
