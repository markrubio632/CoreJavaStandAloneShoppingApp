package com.model;

public class Item {

	private Integer itemId;
	private String itemName;
	private String itemDescrip;
	private double itemPrice;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public Item(Integer itemId, String itemName, String itemDescrip, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescrip = itemDescrip;
		this.itemPrice = itemPrice;
	}

	public Item() {
		super();
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDescrip=" + itemDescrip + ", itemPrice="
				+ itemPrice + "]";
	}

}
