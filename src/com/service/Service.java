package com.service;

import java.util.List;
import java.util.Scanner;

import com.dao.DaoImpl;
import com.model.*;

public class Service {

	DaoImpl daoimpl = new DaoImpl();

	public void RegistrationPage() {

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Please enter a User Name: ");

			String userName = sc.nextLine();
			// user.setUserName(userName);

			System.out.println("Please enter a password - Must follow this format:\n"
					+ "At least 1 Capital, 1 Lowercase, 1 Special Case, and between 8-20 characters:");
			String password = sc.nextLine();

			System.out.println("Please enter your contact number - Must follow this format:\n" + "(XXX)XXX-XXX: ");
			String contactNum = sc.nextLine();

			System.out.println("Please enter your home address: ");
			String address = sc.nextLine();

			daoimpl.saveUser(0, userName, password, contactNum, address, false);
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void loginPage() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter your user name: ");
		String userName = sc.nextLine();

		System.out.println("Please enter your password: ");
		String password = sc.nextLine();

		if (userExists(userName, password)) {

			System.out.println("Logging in");
			
			//log in function - iterator?
			//redirect to different page?

		}

		else {

			System.out.println("User doesn't exist. Please try again");
			//resets the page
			loginPage();

		}

	}

	// determines if the user exists in the DB
	public boolean userExists(String userName, String password) {

		List<User> uList = daoimpl.findAll();

		for (User user : uList) {

			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return true;
			}

		}

		return false;
	}

	// to be used later to determine if the user is logged in
	public boolean isLogged() {
		return true;
	}

}
