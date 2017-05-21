package com.ron.forum.service;

import com.ron.forum.dto.UserLoginDTO;
import com.ron.forum.dto.UserRegisterDTO;
import com.ron.forum.dto.UserDTO;

/**
 * 
 * @author ron
 * @version 1.0
 *
 */
public interface UserService {

	UserDTO login(UserLoginDTO userLoginDTO);
	
	boolean register(UserRegisterDTO userRegisterDTO);
	
	boolean notExistedUser(String username);
}
