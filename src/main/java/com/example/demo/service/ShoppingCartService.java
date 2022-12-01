package com.example.demo.service;

import java.util.Collection;

import com.example.demo.dto.CartItemDTO;

public interface ShoppingCartService {
	public int addOne(CartItemDTO dto);
	public void reduceOne(Long id);
	public void removeItem(Long id);
	public CartItemDTO update(Long id,int qty);
	public void clear();
	public Collection<CartItemDTO> getAllItems();
	public int getCount();
	public int getTotalAmount();
	
}
