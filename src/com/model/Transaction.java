package com.model;

public class Transaction {

	private Integer transId;
	private String transDescrip;
	private String transTime;

	public Transaction(Integer transId, String transDescrip, String transTime) {
		super();
		this.transId = transId;
		this.transDescrip = transDescrip;
		this.transTime = transTime;
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

	public Transaction() {
		super();
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", transDescrip=" + transDescrip + ", transTime=" + transTime + "]";
	}

}
