package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
//import com.example.demo.entity.CustomerEntity;

public interface CustomerService {
	//Tạo account
	void createCustomer(CustomerDTO dto);
	//Kiểm tra đăng nhập
	boolean checkLogin(CustomerDTO dto);
	//Lấy thông tin tài khoản
	CustomerDTO getAccount(CustomerDTO dto);
	//kiểm tra userName
	boolean checkUsername(String username);
}
