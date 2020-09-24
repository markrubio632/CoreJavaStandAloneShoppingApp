package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.DaoImpl;
import com.model.*;
import com.util.Catalog;
import com.util.Menus;

public class Service {

	Catalog catalog = new Catalog();
	Menus menu = new Menus();
	DaoImpl daoimpl = new DaoImpl();

	Scanner sc = new Scanner(System.in);

	// static lists that get populated upon startup
	static List<User> users = new ArrayList<User>();

	static List<Item> cart = new ArrayList<Item>();

	static List<Item> items = new ArrayList<Item>();

	static {

		// user added as an admin
		users.add(new User(1, "Marko", "pass", "(928)928-2677", "123 Jeeves St", true));

		// processors
		items.add(new Item(1, "AMD Ryzen 3600X", "6-core processor - 3.6 GHz", 250.00));
		items.add(new Item(2, "AMD Athlon X4", "4-core processor - 3.2 GHz", 150.00));
		items.add(new Item(3, "AMD Phenom II", "4-core processor - 3.5 GHz", 180.00));

		// motherboards
		items.add(new Item(4, "ASRock X370 Killer SLI/ac", "Built in Wi-Fi adapter", 210.00));
		items.add(new Item(5, "MSI B450 Gaming Plus MAX", "Has an onboard Flash Button", 230.00));
		items.add(new Item(6, "Fatality AB350 Gaming K4", "Accepts wide array of BIOS", 190.00));

		// graphics cards
		items.add(new Item(7, "ASRock Phantom Gaming D RX 570", "Runs Quitely", 310.00));
		items.add(new Item(8, "ASUS TUF Gaming X3 RX 5600", "Dependable, Stable card", 280.00));
		items.add(new Item(9, "GIGABYTE RX 5700 XT GAMING", "Runs hard and plays hard", 350.00));

		// cases
		items.add(new Item(10, "DIYPC Skyline-06-WB ATX Full", "Great case for beginners", 70.00));
		items.add(new Item(11, "Corsair Obsidian Series 750D ATX", "Solid choice, top choice of 2020", 100.00));
		items.add(new Item(12, "Fractal Design Define 7 XL ATX", "Big gamers need big cases", 130.00));

		// power supplies
		items.add(new Item(13, "EVGA SuperNova 650W G5", "Standard series", 140.00));
		items.add(new Item(14, "ThermalTake GF1 650W Gold", "Reputable brand, reputable power", 160.00));
		items.add(new Item(15, "Rosewill LEPTON 600W Modular Gold", "Customizability is crucial", 180.00));

		// memory
		items.add(new Item(16, "G.SKILL Ripjaws V Series 32GB DDR4", "Lots of stuff at once? No problem", 123.00));
		items.add(new Item(17, "CORSAIR Vengeance RGB Pro 16GB DDR4", "Need more colors? We got you", 76.00));
		items.add(new Item(18, "CORSAIR Vengeance LPX 16GB DDR4", "Industry Standard", 70.00));

		// storage
		items.add(new Item(19, "Western Digital WD BLACK SN750 Internal SSD 1TB", "Industry Standard", 110.00));
		items.add(new Item(20, "Crucial P1 1TB 3D NAND Internal", "M2 slot", 130.00));
		items.add(new Item(21, "WD Blue 3D NAND 1TB Internal SSD", "Also Industry Standard", 110.00));

	}

	boolean isLogged = false;
	int input = 0;
	
	String userName;
	String password;
	String contactNum;
	String address;

	public void RegistrationPage() {

		try {

			System.out.println("Please enter a User Name: ");

			userName = sc.nextLine();

			System.out.println("Please enter a password - Must follow this format:\n"
					+ "At least 1 Capital, 1 Lowercase, 1 Special Case, and between 8-20 characters:");
			password = sc.nextLine();

			System.out.println("Please enter your contact number - Must follow this format:\n" + "(XXX)XXX-XXX: ");
			contactNum = sc.nextLine();

			System.out.println("Please enter your home address: ");
			address = sc.nextLine();

			if (userExists(userName, password)) {
				System.out.println("User Name Taken. Please Try again");
				RegistrationPage();
			} else {
				// used to save directly to DB
				// daoimpl.saveUser(0, userName, password, contactNum, address, false);

				// used to save to local arraylist
				System.out.println("user created");
				users.add(new User(0, userName, password, contactNum, address, false));
				System.out.println(users.toString());
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

		}

		else {

			System.out.println("User doesn't exist. Please try again");
		}
		return loggedUser;

	}

	public void StartPage() {
		menu.StartUpMenu();
		input = sc.nextInt();
		sc.nextLine();
		if (input == 1) {
			RegistrationPage();
		} else if (input == 2) {
			loginPage();
		} else if (input == 3) {
			menu.ComponentMenu();
		} else if (input == 4) {
			// insert replacement method
		} else if (input == 5) {
			System.exit(0);
		}
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
			input = sc.nextInt();
			if (input == 1) {

				menu.ComponentMenu();

			} else if (input == 2) {
				loginUser.toString();
			} else if (input == 3) {
				// purchase history
			} else if (input == 4) {

				// logout
				loginUser.equals(null);
				// redirect to start menu
				StartPage();

			} else if (input == 5) {
				// exit
				System.exit(0);
			}

		} else {
			System.out.println("User not logged in. Returning to Start Up...");
			StartPage();
		}

	}

}
