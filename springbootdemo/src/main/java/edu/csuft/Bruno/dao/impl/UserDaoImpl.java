package edu.csuft.Bruno.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.csuft.Bruno.dao.UserDao;
import edu.csuft.Bruno.entity.User;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Autowired
	public void init(SqlSessionTemplate sqlSessionTemplate) {
		this.setSqlSessionTemplate(sqlSessionTemplate);
	}	
	
	@Override
	public List<User> selectAllUsers() {
		return this.getSqlSessionTemplate().selectList("selectAllUsers");
	}

}
