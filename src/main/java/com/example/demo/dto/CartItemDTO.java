package com.example.demo.dto;

public class CartItemDTO {
	private Long VegetableID;
	private String VegetableName;
	private String Image;
	private int Price;
	private int Qty;
	public Long getVegetableID() {
		return VegetableID;
	}
	public void setVegetableID(Long vegetableID) {
		VegetableID = vegetableID;
	}
	public String getVegetableName() {
		return VegetableName;
	}
	public void setVegetableName(String vegetableName) {
		VegetableName = vegetableName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	
}
