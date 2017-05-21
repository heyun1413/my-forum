package com.ron.forum.service;

import com.ron.forum.dto.LoginInfo;
import com.ron.forum.dto.RegisterInfo;
import com.ron.forum.dto.UserInfo;

/**
 * 
 * @author ron
 * @version 1.0
 *
 */
public interface UserService {

	UserInfo login(LoginInfo userLoginInfo);
	
	boolean register(RegisterInfo userRegisterDTO);
	
	boolean notExistedUser(String username);
}
