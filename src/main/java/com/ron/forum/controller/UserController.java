package com.ron.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ron.forum.dto.UserInfo;
import com.ron.forum.dto.LoginInfo;
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
	
	@PostMapping("/login")
	@ResponseBody
	int login(@RequestBody LoginInfo loginInfo) {
		UserInfo userInfo = userService.login(loginInfo);
		return userInfo == null ? 0 : 200;
	}
}
