package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;
	private final OrderMapper orderMapper;
	private final CustomerRepository customerRepository;
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository,OrderMapper orderMapper,CustomerRepository customerRepository) {
		this.orderRepository=orderRepository;
		this.orderMapper=orderMapper;
		this.customerRepository=customerRepository;
	}
	//thêm order và trả về idOrder
	@Override
	public Long createNewOrder(OrderDTO dto) {
		OrderEntity entity = orderMapper.toEntity(dto);
		CustomerEntity customerEntity = customerRepository.getAccountByCustomerID(dto.getCustomerID());
		Long newOrderID = orderRepository.createNewOrderID();
		
		entity.setOrderID(newOrderID);
		entity.setCustomerEntity(customerEntity);
		orderRepository.save(entity);
		return newOrderID;
	}
	
	//Lấy danh sách order
	@Override
	public List<OrderDTO> getListOrder() {
		List<OrderDTO> listDTO=new ArrayList<OrderDTO>();
		List<OrderEntity> listEntity = orderRepository.findAll();
		for(OrderEntity entity: listEntity) {
			OrderDTO dto = orderMapper.toDTO(entity);
			listDTO.add(dto);
		}
		return listDTO;
	}
	
	
	
}
