package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
//import com.example.demo.entity.CustomerEntity;

public interface CustomerService {
	void createCustomer(CustomerDTO dto);
	boolean checkLogin(CustomerDTO dto);
	CustomerDTO getAccount(CustomerDTO dto);
	boolean checkUsername(String username);
}
