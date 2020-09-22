package com.controller;

import com.dao.DaoImpl;

public class Controller {
	
	DaoImpl daoimpl = new DaoImpl();
	
	public void mainController() {
		
		while(true) {
			
			daoimpl.getConnection();
			
		}
		
	}

}
