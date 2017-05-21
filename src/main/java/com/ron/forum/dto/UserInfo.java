package com.ron.forum.dto;

import java.io.InputStream;

public class UserInfo {

	private String nickname;
	private String gender;
	private InputStream portrait;
	private String integral;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public InputStream getPortrait() {
		return portrait;
	}
	public void setPortrait(InputStream portrait) {
		this.portrait = portrait;
	}
	public String getIntegral() {
		return integral;
	}
	public void setIntegral(String integral) {
		this.integral = integral;
	}
	
	
	
}
