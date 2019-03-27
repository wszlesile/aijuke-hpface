package com.aijuke.hpface.common;

public class GenerateIdUtil {
	public static Long generateId() {
		Long id = 0l;
		try {
			id = (long) (Math.random() * 9 * Math.pow(10, 18 - 1)) + (long) Math.pow(10, 18 - 1);
		} catch (Exception e) {
			id = (long) (Math.random() * 9 * Math.pow(10, 18 - 1)) + (long) Math.pow(10, 18 - 1) + 1;
		}
		return id;
	}
}
