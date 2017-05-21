package com.ron.forum.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ron.forum.dao.UserDao;
import com.ron.forum.domain.User;
/**
 * 
 * @author ron
 * @version 1.0
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public User findByUsername(String username) {
		return sqlSession.selectOne("findUserByUsername", username);
	}

	@Override
	public void save(User user) {
		sqlSession.insert("saveUser", user);
	}

}
