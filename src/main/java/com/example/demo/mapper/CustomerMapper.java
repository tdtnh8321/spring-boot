package com.example.demo.mapper;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.CustomerEntity;

@Component
public class CustomerMapper {
    public CustomerEntity toEntity(CustomerDTO dto){
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerID(dto.getCustomerID());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFullname(dto.getFullname());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());

        return entity;
    }
    public CustomerDTO toDTO(CustomerEntity entity){
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerID(entity.getCustomerID());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setFullname(entity.getFullname());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        return dto;
    }
}
