package com.ron.forum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	int login(@RequestBody LoginInfo loginInfo, HttpSession session) {
		System.out.println("login");
		if (loginable(session)) {
			boolean successLogin = userService.login(loginInfo) != null;
			if (successLogin) return 200;
		}
		return 0;
	}
	
	boolean loginable(HttpSession session) {
		return session.getAttribute(VerifyCodeController.ENABLE_LOGIN) == Boolean.TRUE;
	}
}
