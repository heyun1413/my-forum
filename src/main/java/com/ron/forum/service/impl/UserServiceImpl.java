package com.ron.forum.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.ron.forum.dao.UserDao;
import com.ron.forum.domain.Level;
import com.ron.forum.domain.User;
import com.ron.forum.dto.UserDTO;
import com.ron.forum.dto.UserLoginDTO;
import com.ron.forum.dto.UserRegisterDTO;
import com.ron.forum.service.EmailService;
import com.ron.forum.service.UserService;
/**
 * 
 * @author ron
 * @version 1.0
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Resource
	private JmsTemplate jmsQueueTemplate;
	@Autowired
	private EmailService emailService;
	
	@Override
	public UserDTO login(UserLoginDTO userLoginDTO) {
		if (userLoginDTO == null)
			throw new NullPointerException();
		User user = userDao.findByUsername(userLoginDTO.getUsername());
		if (user != null && user.getPassword().equals(userLoginDTO.getPassword())) {
			UserDTO userVO = new UserDTO();
			userVO.setNickname(user.getNickname());
			userVO.setGender(user.getGender().name());
			userVO.setIntegral(Level.levelOf(user.getIntegral()).name());
			return userVO;
		}
		return null;
	}

	@Override
	public boolean register(UserRegisterDTO userRegisterDTO) {
		Objects.requireNonNull(userRegisterDTO);
		if (notExistedUser(userRegisterDTO.getUsername())) {
			emailService.createEmail(userRegisterDTO.getEmail());
		}
		return false;
	}

	@Override
	public boolean notExistedUser(String username) {
		return userDao.findByUsername(username) == null;
	}

}
