package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CartItemDTO;
import com.example.demo.entity.CartItemEntity;

@Component
public class CartItemMapper {
	public CartItemEntity toEntity(CartItemDTO dto) {
		CartItemEntity entity = new CartItemEntity();
		entity.setVegetableID(dto.getVegetableID());
		entity.setVegetableName(dto.getVegetableName());
		entity.setPrice(dto.getPrice());
		entity.setQty(dto.getQty());
		return entity;
	}
	
	public CartItemDTO toDTO(CartItemEntity entity) {
		CartItemDTO dto = new CartItemDTO();
		dto.setVegetableID(entity.getVegetableID());
		dto.setVegetableName(entity.getVegetableName());
		dto.setPrice(entity.getPrice());
		dto.setQty(entity.getQty());
		return dto;
	}
}
