package com.ron.forum.domain;

public enum Gender {
	
	UNKNOW(0), MALE(1), FEMALE(2);
	private final int value;
	
	Gender(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Gender genderOf(int value) {
		switch (value) {
		case 0 : return UNKNOW;
		case 1 : return MALE;
		case 2 : return FEMALE;
		default:
			throw new IllegalArgumentException("不存在该值所对应的性别");
		}
	}
	
}
