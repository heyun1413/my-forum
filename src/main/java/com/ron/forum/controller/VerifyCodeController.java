package com.ron.forum.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ron.forum.util.Captcha;

@Controller
public class VerifyCodeController {
	public static final String VERIFY_CODE_KEY = "code";
	
	@RequestMapping("/code")
	void verifyCodeStream(HttpSession session, HttpServletResponse response) throws IOException {
		// 设置响应的类型格式为图片格式  
        response.setContentType("image/jpeg");  
        // 禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        Captcha instance = new Captcha();  
        session.setAttribute(VERIFY_CODE_KEY, instance.getCode());
        Cookie cookie = new Cookie("captcha", instance.getCode());  
        cookie.setMaxAge(1800);  
        response.addCookie(cookie);  
        instance.write(response.getOutputStream());  
	}
}
