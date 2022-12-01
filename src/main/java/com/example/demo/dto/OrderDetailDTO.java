package com.example.demo.dto;

public class OrderDetailDTO {
		private Long ID;
	   private Long orderID;
	   private Long VegetableID;
	    private String VegetableName;
	    private int Price;
	    private int Quantity;
		public Long getID() {
			return ID;
		}
		public void setID(Long iD) {
			ID = iD;
		}
		public Long getOrderID() {
			return orderID;
		}
		public void setOrderID(Long orderID) {
			this.orderID = orderID;
		}
		
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
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
	    

}
