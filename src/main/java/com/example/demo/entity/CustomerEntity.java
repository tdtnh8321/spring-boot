package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {
	@Id
	@Column(name = "CustomerID")
	private Long CustomerID;

	@Column(name = "Username")
	private String Username;

	@Column(name = "Password")
	private String Password;

	@Column(name = "Fullname")
	private String Fullname;

	@Column(name = "Address")
	private String Address;

	@Column(name = "City")
	private String City;

	@OneToMany(mappedBy = "customerEntity")
	private List<OrderEntity> listOrderEnities;

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		CustomerID = customerID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public List<OrderEntity> getListOrderEnities() {
		return listOrderEnities;
	}

	public void setListOrderEnities(List<OrderEntity> listOrderEnities) {
		this.listOrderEnities = listOrderEnities;
	}
}
