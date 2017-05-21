package com.ron.forum.dao;

import com.ron.forum.domain.User;

/**
 * 
 * @author ron
 * @version 1.0
 *
 */
public interface UserDao {

	User findByUsername(String username);
	
	void save(User user);
}
