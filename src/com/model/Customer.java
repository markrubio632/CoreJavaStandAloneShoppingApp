package com.model;

public class Customer {

	private Integer custId;
	private String userName;
	private String password;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
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

	public Customer(Integer custId, String userName, String password) {
		super();
		this.custId = custId;
		this.userName = userName;
		this.password = password;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", userName=" + userName + ", password=" + password + "]";
	}

}
