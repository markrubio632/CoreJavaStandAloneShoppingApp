package com.util;

public class InputValidation {
	
	public boolean ValidContactNum(String contactNum) {
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
		public boolean ValidPassword(String password) {
			if (password.matches("(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!*]).{8,30}")) {
				return true;
			} else
				return false;
		}
		
		//username must contain at least 1 upper 1 lower and between 3-20 characters
		public boolean ValidUserName(String userName) {
			if (userName.matches("(?=.*[a-z])(?=.*[A-Z]).{3,20}")) {
				return true;
			} else
				return false;
		}
}
