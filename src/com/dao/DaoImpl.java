package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoImpl {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement stmt;
	
	private static final String CREATE_CUSTOMER_TABLE="create table shop_customer(custId integer auto_increment primary key, userName varchar(20), password varchar (30))";
	private static final String CREATE_ITEM_TABLE="create table shop_item(itemId integer auto_increment primary key, itemDescrip varchar(200), itemPrice double)";
	private static final String CREATE_TRANSACTION_TABLE="create table shop_transaction(transId Integer auto_increment primary key, transDescrip varchar(100), transTime varchar(30))";
	
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			return conn;
		} catch (Exception e) {
			System.out.println("issue with connection");
		}
		return conn;
	}

}
