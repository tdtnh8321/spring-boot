package com.example.demo.mapper;


import org.springframework.stereotype.Component;

import com.example.demo.dto.VegetableDTO;
import com.example.demo.entity.VegetableEntity;
@Component
public class VegetableMapper {
    public VegetableEntity toEntity(VegetableDTO vegetableDTO){
        VegetableEntity entity = new VegetableEntity();
        entity.setVegetableID(vegetableDTO.getVegetableID());
        entity.setVegetableName(vegetableDTO.getVegetableName());
        entity.setAmount(vegetableDTO.getAmount());
        entity.setImage(vegetableDTO.getImage());
        entity.setPrice(vegetableDTO.getPrice());
        entity.setUnit(vegetableDTO.getUnit());

        return entity;
    }
    public VegetableDTO toDTO(VegetableEntity entity){
        VegetableDTO dto = new VegetableDTO();
        dto.setVegetableID(entity.getVegetableID());
        dto.setVegetableName(entity.getVegetableName());
        dto.setAmount(entity.getAmount());
        dto.setImage(entity.getImage());
        dto.setPrice(entity.getPrice());
        dto.setUnit(entity.getUnit());

        return dto;
    }
}
