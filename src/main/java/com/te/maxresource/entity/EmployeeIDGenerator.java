package com.te.maxresource.entity;

public class EmployeeIDGenerator {
	private static final String PREFIX = "TYSS";
	private static int currentId = 1;

	public static String getGeneratedEmployeeID() {
		return PREFIX + String.format("%04d", currentId++);
	}
}
