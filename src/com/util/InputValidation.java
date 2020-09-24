package com.util;

public class InputValidation {
	
	public static boolean ValidContactNum(String contactNum) {
		// checks to see if there is a format of (XXX)XXX-XXXX
		if (contactNum.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
			return true;
		} else {
			return false;
		}
	}
	
	// password validation
		// criteria - at least: 1 number, 1 lower case, 1 upper case, 1 special
		// character, 8-30 characters long
		public static boolean ValidPassword(String password) {
			if (password.matches("(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!*]).{8,30}")) {
				return true;
			} else
				return true;
		}
}
