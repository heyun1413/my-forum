package com.ron.forum.domain;

public enum Level {
	ONE_STAR(100), TWO_STAR(500), THREE_STAR(1000), FOUR_STAR(2000),
	FIVE_STAR(5000), SIX_STAR(10000), SEVEN_STAR(20000);
	private final int value;
	Level(int value) {
		this.value = value;
	}
	
	public static Level levelOf(int value) {
		Level[] levels = values();
		Level previousLevel = levels[0];
		for (int i = 1, len = levels.length; i < len; ++i) {
			if (levels[i].value > value) {
				return previousLevel;
			}
			previousLevel = levels[i];
		}
		throw new IllegalArgumentException("没有对应的等级");
	}
}