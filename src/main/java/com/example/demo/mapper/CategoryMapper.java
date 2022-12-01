package com.example.demo.mapper;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;

@Component
public class CategoryMapper {
    public CategoryEntity toEntity(CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setCatagoryID(dto.getCatagoryID());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public CategoryDTO toDTO(CategoryEntity entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setCatagoryID(entity.getCatagoryID());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
