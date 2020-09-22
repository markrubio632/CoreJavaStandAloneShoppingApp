package com.model;

public class User {

	private Integer userId;
	private String userName;
	private String password;
	private String contactNum;
	private String address;
	private boolean isAdmin;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User() {
		super();
	}

	public User(Integer userId, String userName, String password, String contactNum, String address, boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.contactNum = contactNum;
		this.address = address;
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", contactNum="
				+ contactNum + ", address=" + address + ", isAdmin=" + isAdmin + "]";
	}

}
