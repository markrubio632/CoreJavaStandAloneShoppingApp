package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.DaoImpl;
import com.model.*;
import com.util.Catalog;
import com.util.Menus;

public class Service {

	Catalog catalog;
	Menus menu;
	DaoImpl daoimpl = new DaoImpl();

	//static lists that get populated upon startup
	static List<User> users = new ArrayList<User>();
	
	static List<Item> cart = new ArrayList<Item>();
	
	static List<Item> items = new ArrayList<Item>();
	
	static {
		users.add(new User(0, "Marko", "pass", "(928)928-2677", "123 Jeeves St", true));
		
		
	}
	
	
	
	

	boolean isLogged = false;
	int input = 0;

	public void RegistrationPage() {

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Please enter a User Name: ");

			String userName = sc.nextLine();

			System.out.println("Please enter a password - Must follow this format:\n"
					+ "At least 1 Capital, 1 Lowercase, 1 Special Case, and between 8-20 characters:");
			String password = sc.nextLine();

			System.out.println("Please enter your contact number - Must follow this format:\n" + "(XXX)XXX-XXX: ");
			String contactNum = sc.nextLine();

			System.out.println("Please enter your home address: ");
			String address = sc.nextLine();

			if (userExists(userName, password)) {
				System.out.println("User Name Taken. Please Try again");
				sc.close();
				RegistrationPage();
			} else {
				// used to save directly to DB
				// daoimpl.saveUser(0, userName, password, contactNum, address, false);

				// used to save to local arraylist
				users.add(new User(0, userName, password, contactNum, address, false));
				sc.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User loginPage() {

		User loggedUser = new User();

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter your user name: ");
		String userName = sc.nextLine();

		System.out.println("Please enter your password: ");
		String password = sc.nextLine();

		if (userExists(userName, password)) {

			System.out.println("Logging in");

			loggedUser = LoginTime(userName, password);
			// redirect to different page?

			sc.close();

		}

		else {

			System.out.println("User doesn't exist. Please try again");
			sc.close();
		}
		return loggedUser;

	}

	// determines if the user exists in the DB
	public boolean userExists(String userName, String password) {

		// to be used with sql
		// List<User> uList = daoimpl.findAll();

		// used to be uList
		for (User user : users) {

			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return true;
			}

		}

		return false;
	}

	public User LoginTime(String userName, String password) {

		User logger = new User();

		for (User user : users) {

			if (userExists(userName, password)) {
				logger.setUserId(user.getUserId());
				logger.setUserName(user.getUserName());
				logger.setPassword(user.getPassword());
				logger.setContactNum(user.getContactNum());
				logger.setAddress(user.getAddress());
				logger.setAdmin(user.isAdmin());
				isLogged = true;
			}

		}

		return logger;

	}

	public void MainMenu(User loginUser, boolean isLogged) {

		if (isLogged) {

			menu.LoggedMenu();
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
			sc.close();
			if (input == 1) {

				menu.ComponentMenu();

			}
			else if(input == 2) {
				loginUser.toString();
			}
			else if(input == 3) {
				//purchase history
			}
			else if(input == 4) {
				//logout
			}
			else if(input == 5) {
				//exit
			}
			
		} else {
			System.out.println("User not logged in. Please log in first");
			// redirect in controller
		}

	}

}
