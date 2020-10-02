package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.model.User;

public class DaoImpl {

	Connection conn;
	ResultSet rs;
	PreparedStatement stmt;

	private static final String CREATE_USER_TABLE = "create table shop_user(userId integer auto_increment primary key, userName varchar(20), password varchar (20), contactNum varchar(20), address varchar(30), isAdmin bool)";
	private static final String CREATE_ITEM_TABLE = "create table shop_item(itemId integer auto_increment primary key, itemName varchar(30), itemDescrip varchar(200), itemPrice double)";
	private static final String CREATE_TRANSACTION_TABLE = "create table shop_transaction(transId Integer auto_increment primary key, transDescrip varchar(100), transTime varchar(30), foreign key(userId) references shop_user(userId), foreign key(itemId) references shop_item(itemId))";

	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// not really needed
	private static final String USERS = "Select * from shop_user";
	// may replace the catalog
	private static final String ITEMS = "Select * from shop_item";
	// maybe refined to be top 5 transactions in history where transId=?
	private static final String TRANSACTIONS = "Select * from shop_transaction";

	// used to save user
	private static final String SAVE_USER = "insert into shop_user(userId, userName, password, contactNum, address, isAdmin) values"
			+ "(?,?,?,?,?,?)";

	// used to grab a specific user
	private static final String SPECIFIC_USER = "Select * from shop_user where userId=?";

	public Connection getConnection() {
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

	public void createDatabases() {

		try {// connects to DB and automatically returns conn with a value
				// assuming there were no errors
			conn = getConnection();

			if (conn != null) {
				// should execute and create all 3 tables
				stmt = conn.prepareStatement(CREATE_USER_TABLE);
				stmt.executeUpdate();
				System.out.println("customer table created");

				stmt = conn.prepareStatement(CREATE_ITEM_TABLE);
				stmt.executeUpdate();
				System.out.println("Item table created");

				stmt = conn.prepareStatement(CREATE_TRANSACTION_TABLE);
				stmt.executeUpdate();
				System.out.println("Transaction table created");
				conn.close();
			} else {
				System.out.println("Conn was null");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<User> findAll() {

		List<User> uList = new ArrayList<>();

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(USERS);
			rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getInt("userId"), rs.getString("userName"), rs.getString("password"),
						rs.getString("contactNum"), rs.getString("address"), rs.getBoolean("isAdmin"));

				uList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uList;
	}

	public User findUserById(int id) {

		User cust = new User();

		conn = getConnection();

		if (conn != null) {

			try {
				stmt = conn.prepareStatement(SPECIFIC_USER);

				stmt.setInt(1, id);

				rs = stmt.executeQuery();

				while (rs.next()) {
					// should display the user to the console using toString
					cust.toString();

					// may need to explicitly write everything out
					// rs.getInt(1) etc
				}
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return cust;

	}

	public void saveUser(Integer userId, String userName, String password, String contactNum, String address,
			boolean isAdmin) {

		try {

			conn = getConnection();

			stmt = conn.prepareStatement(SAVE_USER);

			stmt.setInt(1, userId);
			stmt.setString(2, userName);
			stmt.setString(3, password);
			stmt.setString(4, contactNum);
			stmt.setString(5, address);
			stmt.setBoolean(6, isAdmin);

			stmt.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
