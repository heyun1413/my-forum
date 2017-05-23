package com.ron.forum.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VerifyCodeController {
	private static final String VERIFY_CODE_KEY = "code";
	public static final String ENABLE_LOGIN = "enableLogin";
	
	@RequestMapping("/code")
	void verifyCodeStream(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("image/jpeg");  
//        response.setHeader("Pragma", "no-cache");  
//        response.setHeader("Cache-Control", "no-cache");  
//        response.setDateHeader("Expires", 0);  
//        Captcha instance = new Captcha();  
//        session.setAttribute(VERIFY_CODE_KEY, instance.getCode());
//        instance.write(response.getOutputStream()); 
        System.out.println("code/" + request.getSession(false));
        for(Cookie cookie : request.getCookies()) {
        	System.out.println(cookie.getName() + cookie.getValue());
        }
	}
	
	@PostMapping("/confirm-code")
	@ResponseBody int checkVerifyCode(HttpSession session, String verifyCode) {
		System.out.println("verifyCode/" + session);
		if (verifyCode != null && verifyCode.equalsIgnoreCase(
				session.getAttribute(VERIFY_CODE_KEY).toString())) {
			session.setAttribute(ENABLE_LOGIN, Boolean.TRUE);
			return 200;
		}
		session.setAttribute(ENABLE_LOGIN, Boolean.FALSE);
		return 0;
	}
}
