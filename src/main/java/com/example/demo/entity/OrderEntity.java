package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	@Column(name = "OrderID")
	private Long OrderID;

	@Column(name = "Date")
	private String Date;

	@Column(name = "Total")
	private int Total;

	@Column(name = "Note")
	private String Note;

	@ManyToOne
	@JoinColumn(name = "CustomerID")
	private CustomerEntity customerEntity;

	@OneToMany(mappedBy = "orderEntity")
	private List<OrderDetailEntity> listOrderDetailEnities;

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long orderID) {
		OrderID = orderID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public List<OrderDetailEntity> getListOrderDetailEnities() {
		return listOrderDetailEnities;
	}

	public void setListOrderDetailEnities(List<OrderDetailEntity> listOrderDetailEnities) {
		this.listOrderDetailEnities = listOrderDetailEnities;
	}

	
}
