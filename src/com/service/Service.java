package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.DaoImpl;
import com.model.*;
import com.util.Catalog;
import com.util.Menus;

public class Service {
	
	//todo list:
	//ADD TRANSACTIONS
	//MODIFY ITEMS IN CATALOG - DESCRIPTION AND PRICE REFLECTED

	// Catalog catalog = new Catalog();
	Menus menu = new Menus();
	DaoImpl daoimpl = new DaoImpl();
	User loggedUser = new User();

	Scanner sc = new Scanner(System.in);

	// static lists that get populated upon startup
	static List<User> users = new ArrayList<User>();

	static List<Item> cart = new ArrayList<Item>();

	static List<Item> items = new ArrayList<Item>();
	
	static List<Transaction> transList = new ArrayList<Transaction>();
	
	boolean isLogged = false;
	int input = 0;
	static int userIdCounter = 0; //used to give a static counter - increments in the user addition
	static int itemCounter = 0;
	static int transCounter = 0;

	String userName;
	String password;
	String contactNum;
	String address;

	static {

		// user added as an admin
		users.add(new User(userIdCounter++, "Marko", "pass", "(928)928-2677", "123 Jeeves St", true));

		// processors
		items.add(new Item(itemCounter++, "AMD Ryzen 3600X", "6-core processor - 3.6 GHz", 250.00));
		items.add(new Item(itemCounter++, "AMD Athlon X4", "4-core processor - 3.2 GHz", 150.00));
		items.add(new Item(itemCounter++, "AMD Phenom II", "4-core processor - 3.5 GHz", 180.00));

		// motherboards
		items.add(new Item(itemCounter++, "ASRock X370 Killer SLI/ac", "Built in Wi-Fi adapter", 210.00));
		items.add(new Item(itemCounter++, "MSI B450 Gaming Plus MAX", "Has an onboard Flash Button", 230.00));
		items.add(new Item(itemCounter++, "Fatality AB350 Gaming K4", "Accepts wide array of BIOS", 190.00));

		// graphics cards
		items.add(new Item(itemCounter++, "ASRock Phantom Gaming D RX 570", "Runs Quitely", 310.00));
		items.add(new Item(itemCounter++, "ASUS TUF Gaming X3 RX 5600", "Dependable, Stable card", 280.00));
		items.add(new Item(itemCounter++, "GIGABYTE RX 5700 XT GAMING", "Runs hard and plays hard", 350.00));

		// cases
		items.add(new Item(itemCounter++, "DIYPC Skyline-06-WB ATX Full", "Great case for beginners", 70.00));
		items.add(new Item(itemCounter++, "Corsair Obsidian Series 750D ATX", "Solid choice, top choice of 2020", 100.00));
		items.add(new Item(itemCounter++, "Fractal Design Define 7 XL ATX", "Big gamers need big cases", 130.00));

		// power supplies
		items.add(new Item(itemCounter++, "EVGA SuperNova 650W G5", "Standard series", 140.00));
		items.add(new Item(itemCounter++, "ThermalTake GF1 650W Gold", "Reputable brand, reputable power", 160.00));
		items.add(new Item(itemCounter++, "Rosewill LEPTON 600W Modular Gold", "Customizability is crucial", 180.00));

		// memory
		items.add(new Item(itemCounter++, "G.SKILL Ripjaws V Series 32GB DDR4", "Lots of stuff at once? No problem", 123.00));
		items.add(new Item(itemCounter++, "CORSAIR Vengeance RGB Pro 16GB DDR4", "Need more colors? We got you", 76.00));
		items.add(new Item(itemCounter++, "CORSAIR Vengeance LPX 16GB DDR4", "Industry Standard", 70.00));

		// storage
		items.add(new Item(itemCounter++, "Western Digital WD BLACK SN750 Internal SSD 1TB", "Industry Standard", 110.00));
		items.add(new Item(itemCounter++, "Crucial P1 1TB 3D NAND Internal", "M2 slot", 130.00));
		items.add(new Item(itemCounter++, "WD Blue 3D NAND 1TB Internal SSD", "Also Industry Standard", 110.00));

	}

	

	public void StartPage() {
		menu.StartUpMenu();
		input = sc.nextInt();
		sc.nextLine();
		if (input == 1) {
			RegistrationPage();
		} else if (input == 2) {
			loginPage();
			MainMenu(loggedUser, isLogged);
		} else if (input == 3) {
			menu.ComponentMenu();
		} else if (input == 4) {
			// insert replacement method
		} else if (input == 5) {
			System.exit(0);
		}
	}

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
				users.add(new User(userIdCounter++, userName, password, contactNum, address, false)); //uses counter to increase all user IDs by 1
				System.out.println(users.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User loginPage() {

		loggedUser = emptyLogin(loggedUser);

		System.out.println("Please enter your user name: ");
		String userName = sc.nextLine();

		System.out.println("Please enter your password: ");
		String password = sc.nextLine();

		if (userExists(userName, password)) {

			loggedUser = LoginTime(userName, password);
			isLogged = true;

			System.out.println(loggedUser.getUserName() + " ...Logging in");

		}

		else {

			System.out.println("User doesn't exist. Please try again");
		}
		return loggedUser;

	}

	public void MainMenu(User loggedUser, boolean isLogged) {

		if (isLogged) {

			menu.LoggedMenu();

			input = sc.nextInt();

			if (input == 1) {

				menu.ComponentMenu();

				input = sc.nextInt();

				if (input == 1) {
					System.out.println(Catalog.PROCESSORS);
					input = sc.nextInt();

					if (input == 1) {
						cart.add(items.get(0));
						
						cart.get(0);
						
						transList.add(new Transaction(transCounter++, cart.get(0).getItemDescrip(),new Date().toLocaleString(),loggedUser.getUserId(),cart.get(0).getItemId()));
					} else if (input == 2) {
						cart.add(items.get(1));
						AddTransaction(1);
					} else if (input == 3) {
						cart.add(items.get(2));
					} else {
						System.out.println("invalid selection. Returning to Main Menu...");
						MainMenu(loggedUser, isLogged);
					}
				} else if (input == 2) {
					System.out.println(Catalog.MOTHERBOARDS);
					input = sc.nextInt();
					if (input == 1) {
						cart.add(items.get(3));
					} else if (input == 2) {
						cart.add(items.get(4));
					} else if (input == 3) {
						cart.add(items.get(5));
					} else {
						System.out.println("invalid selection. Returning to Main Menu...");
						MainMenu(loggedUser, isLogged);
					}
				} else if (input == 3) {
					System.out.println(Catalog.GRAPHICS);
					input = sc.nextInt();
					if (input == 1) {
						cart.add(items.get(6));
					} else if (input == 2) {
						cart.add(items.get(7));
					} else if (input == 3) {
						cart.add(items.get(8));
					} else {
						System.out.println("invalid selection. Returning to Main Menu...");
						MainMenu(loggedUser, isLogged);
					}
				} else if (input == 4) {
					System.out.println(Catalog.CASES);
					input = sc.nextInt();
					if (input == 1) {
						cart.add(items.get(9));
					} else if (input == 2) {
						cart.add(items.get(10));
					} else if (input == 3) {
						cart.add(items.get(11));
					} else {
						System.out.println("invalid selection. Returning to Main Menu...");
						MainMenu(loggedUser, isLogged);
					}
				} else if (input == 5) {
					System.out.println(Catalog.POWER);
					input = sc.nextInt();
					if (input == 1) {
						cart.add(items.get(12));
					} else if (input == 2) {
						cart.add(items.get(13));
					} else if (input == 3) {
						cart.add(items.get(14));
					} else {
						System.out.println("invalid selection. Returning to Main Menu...");
						MainMenu(loggedUser, isLogged);
					}
				} else if (input == 6) {
					System.out.println(Catalog.MEMORY);
					input = sc.nextInt();
					if (input == 1) {
						cart.add(items.get(15));
					} else if (input == 2) {
						cart.add(items.get(16));
					} else if (input == 3) {
						cart.add(items.get(17));
					} else {
						System.out.println("invalid selection. Returning to Main Menu...");
						MainMenu(loggedUser, isLogged);
					}
				} else if (input == 7) {
					System.out.println(Catalog.STORAGE);
					input = sc.nextInt();
					if (input == 1) {
						cart.add(items.get(18));
					} else if (input == 2) {
						cart.add(items.get(19));
					} else if (input == 3) {
						cart.add(items.get(20));
					} else {
						System.out.println("invalid selection. Returning to Main Menu...");
						MainMenu(loggedUser, isLogged);
					}
				} else if (input == 8) {
					System.out.println(loggedUser.getUserName() + ": logging out");

					loggedUser = emptyLogin(loggedUser);

					StartPage();
				} else if (input == 9) {
					System.exit(0);
				}
				MainMenu(loggedUser, isLogged);

			} else if (input == 2) {
				// view account

				long total = 0;

				System.out.println(loggedUser);

				if (cart.isEmpty()) {
					System.out.println("Your shopping cart is empty!");
				} else {
					for (Item item : cart) {

						total += item.getItemPrice();

						System.out.println("My shopping cart has: " + item.toString());
					}
					System.out.println("Your total balance is " + total);
				}

				MainMenu(loggedUser, isLogged);

			} else if (input == 3) {
				// purchase history
				
				System.out.println(transList);
				
				for(Transaction trans : transList) {
					System.out.println(trans.getTransDescrip() + " purchased at " + trans.getTransTime());
				}
				

			} else if (input == 4) {
				// logout

				System.out.println(loggedUser.getUserName() + ": logging out");

				loggedUser = emptyLogin(loggedUser);

				StartPage();

			} else if (input == 5) {
				// exit

				sc.close();

				System.exit(0);
			}

		} else {
			System.out.println("User not logged in. Returning to Start Up...");
			StartPage();
		}

	}

	// EXTRA METHODS USED

	// determines if the user exists in the DB or local lists
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

	// used to login the user and set isLogged to true
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

	// empties user and sets isLogged to false
	public User emptyLogin(User loggedUser) {

		loggedUser.setUserId(null);
		loggedUser.setUserName(null);
		loggedUser.setPassword(null);
		loggedUser.setContactNum(null);
		loggedUser.setAddress(null);
		loggedUser.setAdmin(false);

		isLogged = false;

		return loggedUser;
	}
	
	@SuppressWarnings("deprecation")
	public void AddTransaction(int cartIdNumber) {
		transList.add(new Transaction(transCounter++, cart.get(cartIdNumber).getItemDescrip(),new Date().toLocaleString(),loggedUser.getUserId(),cart.get(cartIdNumber).getItemId()));
	}

}
