package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDetailDTO;
import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.VegetableEntity;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.repository.*;
import com.example.demo.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	private final OrderDetailRepository orderDetailRepository;
	private final OrderDetailMapper orderDetailMapper;
	private final OrderRepository orderRepository;
	private final VegetableRepository vegetableRepository;
	@Autowired
	public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository,
			OrderDetailMapper orderDetailMapper,
			OrderRepository orderRepository,
			VegetableRepository vegetableRepository) {
		this.orderDetailMapper = orderDetailMapper;
		this.orderDetailRepository = orderDetailRepository;
		this.orderRepository=orderRepository;
		this.vegetableRepository=vegetableRepository;
	}
	
	
	
	
	//La danh sach
	@Override
	public List<OrderDetailDTO> getList() {
		List<OrderDetailDTO> listDTO=new ArrayList<OrderDetailDTO>();
		List<OrderDetailEntity> listEntity = orderDetailRepository.findAll();
		for(OrderDetailEntity entit : listEntity) {
			OrderDetailDTO dto = orderDetailMapper.toDTO(entit);
			listDTO.add(dto);
		}
		return listDTO;
	}



	//Them danh sach orderDetail
	@Override
	public void addListOrderDetail(List<OrderDetailDTO> list) {
		//Lưu orderDetail
		for(OrderDetailDTO dto : list) {
			OrderDetailEntity entity = orderDetailMapper.toEntity(dto);
			OrderEntity orderEntity = orderRepository.getOrderByIdOrderID(dto.getOrderID());
			VegetableEntity vegetableEntity = vegetableRepository.getVegetableByID(dto.getVegetableID());
						
			entity.setOrderEntity(orderEntity);
			entity.setVegetableEntity(vegetableEntity);
			
			orderDetailRepository.save(entity);

		}
		
		
	}

}
