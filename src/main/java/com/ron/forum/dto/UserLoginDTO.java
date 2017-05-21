package com.ron.forum.dto;

import javax.validation.constraints.Pattern;

public class UserLoginDTO {

	@Pattern(regexp = "^[A-Za-z0-9_]{8-15}$", message = "用户名为字母数字下划线，长度大于等于8小于等于15")
	private String username;
	@Pattern(regexp = "(?:[\\d_])|(?:[A-Za-z_])|(?:[A-Za-z\\d])", message = "密码必须包含字母数字下划线的两种")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
