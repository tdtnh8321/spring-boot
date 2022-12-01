package com.example.demo.mapper;
import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderEntity;

@Component
public class OrderMapper {
    public OrderEntity toEntity(OrderDTO dto){
        OrderEntity entity = new OrderEntity();
        entity.setOrderID(dto.getOrderID());
        entity.setDate(dto.getDate());
        entity.setTotal(dto.getTotal());
        entity.setNote(dto.getNote());
        return entity;
    }

    public OrderDTO toDTO(OrderEntity entity){
        OrderDTO dto = new OrderDTO();
        dto.setOrderID(entity.getOrderID());
        dto.setDate(entity.getDate());
        dto.setTotal(entity.getTotal());
        dto.setNote(entity.getNote());
        return dto;
    }
}
