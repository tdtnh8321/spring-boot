package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository,CategoryMapper categoryMapper) {
		this.categoryRepository=categoryRepository;
		this.categoryMapper=categoryMapper;
	}
	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryEntity> listEntity = categoryRepository.findAll();
		List<CategoryDTO> listDTO = new ArrayList<>();
		for(CategoryEntity entity : listEntity) {
			CategoryDTO dto = categoryMapper.toDTO(entity);
			listDTO.add(dto);
		}
		return listDTO;
	}
	
	
}
