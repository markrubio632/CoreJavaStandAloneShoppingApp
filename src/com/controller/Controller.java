package com.controller;

import com.dao.DaoImpl;
import com.service.Service;

public class Controller {
	
	DaoImpl daoimpl = new DaoImpl();
	Service serv = new Service();
	
	public void mainController() {
		
		while(true) {
			
			//daoimpl.getConnection();
			serv.StartPage();
			
		}
		
	}

}
