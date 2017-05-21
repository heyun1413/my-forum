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

import com.ron.forum.util.Captcha;

@Controller
public class VerifyCodeController {
	private static final String VERIFY_CODE_KEY = "code";
	
	@RequestMapping("/code")
	void verifyCodeStream(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        Captcha instance = new Captcha();  
        HttpSession session = request.getSession();
        session.setAttribute(VERIFY_CODE_KEY, instance.getCode());
        System.out.println(session.getAttribute(VERIFY_CODE_KEY));
        Cookie cookie = new Cookie("captcha", instance.getCode());  
        cookie.setMaxAge(1800);  
        response.addCookie(cookie);  
        instance.write(response.getOutputStream());  
	}
	
	@PostMapping("/confirm-code")
	@ResponseBody
	int checkVerifyCode(HttpSession session, String verifyCode) {
		System.out.println(verifyCode);
		System.out.println(session.getAttribute(VERIFY_CODE_KEY));
		if (verifyCode != null && verifyCode.equalsIgnoreCase(
				session.getAttribute(VERIFY_CODE_KEY).toString())) {
			return 200;
		}
		return 0;
	}
}
