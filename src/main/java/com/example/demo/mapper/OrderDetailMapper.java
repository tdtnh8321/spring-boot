package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderDetailDTO;
import com.example.demo.entity.OrderDetailEntity;

@Component
public class OrderDetailMapper {
	public OrderDetailEntity toEntity(OrderDetailDTO dto) {
		OrderDetailEntity entity = new OrderDetailEntity();
		entity.setID(dto.getID());
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
	public OrderDetailDTO toDTO(OrderDetailEntity entity) {
		OrderDetailDTO dto =new OrderDetailDTO();
		dto.setID(entity.getID());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		return dto;
	}
}
