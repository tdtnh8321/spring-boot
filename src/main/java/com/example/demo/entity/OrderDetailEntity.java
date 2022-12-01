package com.example.demo.entity;
import javax.persistence.*;
@Entity
@Table(name = "orderdetail")
public class OrderDetailEntity {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	
    @Column(name = "Price")
    private int Price;
    @Column(name = "Quantity")
    private int Quantity;
    
    @ManyToOne
    @JoinColumn(name="VegetableID")
    private VegetableEntity vegetableEntity;
    
    @ManyToOne
    @JoinColumn(name="OrderID")
    private OrderEntity orderEntity;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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

	public VegetableEntity getVegetableEntity() {
		return vegetableEntity;
	}

	public void setVegetableEntity(VegetableEntity vegetableEntity) {
		this.vegetableEntity = vegetableEntity;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
    

}
