package com.model;

import java.util.Date;

public class Transaction {

	private Integer transId;
	private String transDescrip;
	private Date transTime;
	private Integer userId;
	private Integer itemId;

	public Transaction(Integer transId, String transDescrip, Date transTime, Integer userId, Integer itemId) {
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

	public Date getTransTime() {
		return transTime;
	}

	public void setTransTime(Date transTime) {
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
