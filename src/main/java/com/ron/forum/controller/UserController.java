package com.ron.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ron.forum.dto.UserLoginDTO;
import com.ron.forum.dto.UserDTO;
import com.ron.forum.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/tologin")
	String toLogin() {
		return "login";
	}
	@RequestMapping("/login")
	String login(UserLoginDTO loginDTO, Model model) {
		UserDTO userVO = userService.login(loginDTO);
		if (userVO == null) {
			return "login";
		}
		return "index";
	}
}
