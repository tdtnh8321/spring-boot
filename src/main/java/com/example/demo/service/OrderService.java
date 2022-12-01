package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderDTO;

public interface OrderService {
	Long createNewOrder(OrderDTO orderDto);
	
	List<OrderDTO> getListOrder();
}
