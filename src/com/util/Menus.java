package com.util;

public class Menus {

	public static final String STARTMENU = "1. REGISTER\n2. LOGIN\n3. BROWSE CATALOG\n" + "4. REPLACE AN ITEM\n5. EXIT";
	
	public static final String COMPONENTMENU = "What Category would you like to look at?\n1. Processors\n2. MotherBoards\n3. Graphics Cards"
			+ "\n4. Cases\n5. Power Supplies\n6. Memory\n7. Storage\n8. Logout\n9. Exit";
	
	public static final String LOGGEDMENU = "1. Browse Catalog\n2. View Account\n3. Purchase History\n4. Logout\n5. Exit";

	public void StartUpMenu() {
		System.out.println(STARTMENU);
	}
	
	public void ComponentMenu() {
		System.out.println(COMPONENTMENU);
	}
	
	public void LoggedMenu() {
		System.out.println(LOGGEDMENU);
	}

}
