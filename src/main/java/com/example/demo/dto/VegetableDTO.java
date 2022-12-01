package com.example.demo.dto;

public class VegetableDTO{
	 private Long VegetableID;
	    private String CategoryName;
	    private String VegetableName;
	    private int Amount;
	    private String Image;
	    private int Price;
	    private String Unit;

	    public Long getVegetableID() {
	        return VegetableID;
	    }

	    public void setVegetableID(Long vegetableID) {
	        VegetableID = vegetableID;
	    }

	    public String getCategoryName() {
	        return CategoryName;
	    }

	    public void setCategoryName(String categoryName) {
	        CategoryName = categoryName;
	    }

	    public String getVegetableName() {
	        return VegetableName;
	    }

	    public void setVegetableName(String vegetableName) {
	        VegetableName = vegetableName;
	    }

	    public int getAmount() {
	        return Amount;
	    }

	    public void setAmount(int amount) {
	        Amount = amount;
	    }

	    public String getImage() {
	        return Image;
	    }

	    public void setImage(String image) {
	        Image = image;
	    }

	    public int getPrice() {
	        return Price;
	    }

	    public void setPrice(int price) {
	        Price = price;
	    }

	    public String getUnit() {
	        return Unit;
	    }

	    public void setUnit(String unit) {
	        Unit = unit;
	    }
}
