package com.model;

public class Item {

	private String itemId;
	private String itemDescrip;
	private double itemPrice;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemDescrip() {
		return itemDescrip;
	}

	public void setItemDescrip(String itemDescrip) {
		this.itemDescrip = itemDescrip;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Item(String itemId, String itemDescrip, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemDescrip = itemDescrip;
		this.itemPrice = itemPrice;
	}

	public Item() {
		super();
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemDescrip=" + itemDescrip + ", itemPrice=" + itemPrice + "]";
	}

}
