package com.model;

public class Transaction {

	private Integer transId;
	private String transDescrip;
	private String transTime;
	private Integer userId;
	private Integer itemId;

	public Transaction(Integer transId, String transDescrip, String transTime, Integer userId, Integer itemId) {
		super();
		this.transId = transId;
		this.transDescrip = transDescrip;
		this.transTime = transTime;
		this.userId = userId;
		this.itemId = itemId;
	}

	public Integer getTransId() {
		return transId;
	}

	public void setTransId(Integer transId) {
		this.transId = transId;
	}

	public String getTransDescrip() {
		return transDescrip;
	}

	public void setTransDescrip(String transDescrip) {
		this.transDescrip = transDescrip;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", transDescrip=" + transDescrip + ", transTime=" + transTime
				+ ", userId=" + userId + ", itemId=" + itemId + "]";
	}

}
