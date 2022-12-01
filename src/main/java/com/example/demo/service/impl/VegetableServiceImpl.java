package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.VegetableDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.VegetableEntity;
import com.example.demo.mapper.VegetableMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.VegetableRepository;
import com.example.demo.service.VegetableService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

	private final VegetableRepository vegetableRepository;

	private final CategoryRepository categoryRepository;

	private final VegetableMapper vegetableMapper;

	@Autowired
	public VegetableServiceImpl(VegetableRepository vegetableRepository, CategoryRepository categoryRepository,
			VegetableMapper vegetableMapper) {
		this.vegetableRepository = vegetableRepository;
		this.categoryRepository = categoryRepository;
		this.vegetableMapper = vegetableMapper;
	}

	@Override
	public List<VegetableDTO> getAllVegetables() {
		List<VegetableEntity> listEntity = vegetableRepository.findAll();

		List<VegetableDTO> listDTO = new ArrayList<VegetableDTO>();
		for (VegetableEntity entity : listEntity) {
			Optional<CategoryEntity> categoryEntity = categoryRepository
					.findById(entity.getCategoryEntity().getCatagoryID());
			VegetableDTO dto = vegetableMapper.toDTO(entity);
			dto.setCategoryName(categoryEntity.get().getName());
			listDTO.add(dto);
		}
		return listDTO;

	}

	@Override
	public VegetableDTO getVegetableById(Long id) {

		VegetableEntity entity = vegetableRepository.findById(id).get();
		CategoryEntity categoryEntity = categoryRepository
				.findById(entity.getCategoryEntity().getCatagoryID()).get();
		VegetableDTO dto = vegetableMapper.toDTO(entity);
		dto.setCategoryName(categoryEntity.getName());
		return dto;
	}

	@Override
	public List<VegetableDTO> getVegetableByCatagoryID(String catagoryID) {
		List<VegetableEntity> listEntity = vegetableRepository.findByCatagoryID(catagoryID);
		List<VegetableDTO> listDTO = new ArrayList<VegetableDTO>();
		for (VegetableEntity entity : listEntity) {
			Optional<CategoryEntity> categoryEntity = categoryRepository
					.findById(entity.getCategoryEntity().getCatagoryID());
			VegetableDTO dto = vegetableMapper.toDTO(entity);
			dto.setCategoryName(categoryEntity.get().getName());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public List<VegetableDTO> getVegetableByVegetableName(String vegetableName) {
		List<VegetableEntity> listEntity = vegetableRepository.findByVegetableName(vegetableName);
		List<VegetableDTO> listDTO = new ArrayList<VegetableDTO>();
		for (VegetableEntity entity : listEntity) {
			Optional<CategoryEntity> categoryEntity = categoryRepository
					.findById(entity.getCategoryEntity().getCatagoryID());
			VegetableDTO dto = vegetableMapper.toDTO(entity);
			dto.setCategoryName(categoryEntity.get().getName());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public List<VegetableDTO> getVegetableByCatagoryIDAndVegetableName(String catagoryID, String vegetableName) {
		List<VegetableEntity> listEntity = vegetableRepository.findByCatagoryIDAndVegetableName(catagoryID,
				vegetableName);
		List<VegetableDTO> listDTO = new ArrayList<VegetableDTO>();
		for (VegetableEntity entity : listEntity) {
			Optional<CategoryEntity> categoryEntity = categoryRepository
					.findById(entity.getCategoryEntity().getCatagoryID());
			VegetableDTO dto = vegetableMapper.toDTO(entity);
			dto.setCategoryName(categoryEntity.get().getName());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public List<VegetableDTO> getSellingVegetable() {
		List<VegetableEntity> listEntity = vegetableRepository.getSellingVegetable();

		List<VegetableDTO> listDTO = new ArrayList<VegetableDTO>();
		for (VegetableEntity entity : listEntity) {
			Optional<CategoryEntity> categoryEntity = categoryRepository
					.findById(entity.getCategoryEntity().getCatagoryID());
			VegetableDTO dto = vegetableMapper.toDTO(entity);
			dto.setCategoryName(categoryEntity.get().getName());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public void updateQty(List<VegetableDTO> list) {
		for(VegetableDTO item : list) {
			System.out.println(item.getVegetableID()+"-----"+item.getAmount());
			VegetableEntity entity = vegetableRepository.findById(item.getVegetableID()).get();
			entity.setAmount(entity.getAmount()-item.getAmount());
			vegetableRepository.save(entity);
		}
	}

}
