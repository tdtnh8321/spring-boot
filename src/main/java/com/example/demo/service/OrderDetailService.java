package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderDetailDTO;

@Component
public interface OrderDetailService {
	List<OrderDetailDTO> getList();
	
	void addListOrderDetail(List<OrderDetailDTO> list);
}
