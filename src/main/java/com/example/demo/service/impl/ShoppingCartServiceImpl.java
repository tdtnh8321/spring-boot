package com.example.demo.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dto.CartItemDTO;
import com.example.demo.repository.VegetableRepository;
import com.example.demo.service.ShoppingCartService;


@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	private final VegetableRepository vegetableRepository;
	@Autowired
	public ShoppingCartServiceImpl(VegetableRepository vegetableRepository) {
		this.vegetableRepository=vegetableRepository;
	}
	
	Map<Long,CartItemDTO> maps = new HashMap<>(); //giỏ hàng
	//thêm 1
	@Override
	public int addOne(CartItemDTO item) {
		int result=0;
		int checkAmount=vegetableRepository.getAmount(item.getVegetableID());
		//Kiem tra item da ton taij trong gio hang hay chua
		CartItemDTO cartItem = maps.get(item.getVegetableID());
		if(cartItem == null) //chua ton tai
		{
			if(item.getQty()>checkAmount) {
				result=0;
			}else {
				maps.put(item.getVegetableID(), item);
				result=1;
			}
			
		}else {
			if(cartItem.getQty()+item.getQty()>checkAmount) {
				result=0;
			}else {
				cartItem.setQty(cartItem.getQty() + item.getQty());
				result=1;
			}
		}
		return result;
	}
	//giảm sl đi 1
	@Override
	public void reduceOne(Long id) {
		CartItemDTO cartItem = maps.get(id);
		cartItem.setQty(cartItem.getQty() - 1);
	}
	//xóa  sản phẩm ra khỏi giỏ
	@Override
	public void removeItem(Long id) {
		maps.remove(id);
	}
	//cập nhật số lượng trong giỏ của 1 item
	@Override
	public CartItemDTO update(Long id,int qty) {
		CartItemDTO cartItem = maps.get(id);
		cartItem.setQty(qty);
		return cartItem;
	}
	//xóa giỏ hàng
	@Override
	public void clear() {
		maps.clear();
	}
	//lấy sản phẩm trong giỏ
	@Override
	public Collection<CartItemDTO> getAllItems(){
		return maps.values();
	}
	//tổng số lượng
	@Override
	public int getCount() {
		return maps.values().size();
	}
	//Tổng tiền
	@Override
	public int getTotalAmount() {
		return maps.values().stream().mapToInt(item->item.getQty()*item.getPrice()).sum();
	}
	
}
