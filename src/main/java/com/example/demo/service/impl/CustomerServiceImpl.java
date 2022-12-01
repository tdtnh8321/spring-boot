package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository,CustomerMapper customerMapper) {
		this.customerRepository=customerRepository;
		this.customerMapper=customerMapper;
	}
	
	
	@Override
	public void createCustomer(CustomerDTO dto) {
		CustomerEntity entity = customerMapper.toEntity(dto);
		Long newid = customerRepository.count()+1;
		entity.setCustomerID(newid);
		customerRepository.save(entity);
	}


	@Override
	public boolean checkLogin(CustomerDTO dto) {
		int check=customerRepository.checkLogin(dto.getUsername(), dto.getPassword());
		
		return check>0;
	}


	@Override
	public CustomerDTO getAccount(CustomerDTO dto) {
		CustomerEntity entity = customerRepository.getAccount(dto.getUsername(), dto.getPassword());
		CustomerDTO account = customerMapper.toDTO(entity);
		return account;
	}


	@Override
	public boolean checkUsername(String username) {
		int check = customerRepository.checkUsername(username);
		return check == 0;
	}


	

}
