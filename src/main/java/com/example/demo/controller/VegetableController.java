package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.VegetableDTO;
import com.example.demo.service.CategoryService;
import com.example.demo.service.VegetableService;

@RestController
@RequestMapping("/")
public class VegetableController {
	private final VegetableService vegetableService;
	private final CategoryService categoryService;

	@Autowired
	public VegetableController(VegetableService vegetableService, CategoryService categoryService) {
		this.vegetableService = vegetableService;
		this.categoryService = categoryService;
	}

	// trang chủ(xem tất cả sản phẩm)
	@GetMapping("/home")
	public ModelAndView index() {
		List<VegetableDTO> listData = vegetableService.getAllVegetables();
		List<CategoryDTO> listCategory = categoryService.getAllCategory();
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("listVegetable", listData);
		mv.addObject("listCategory", listCategory);
		return mv;
	}

	// tìm kiếm sản phẩm theo tên và loại
	@GetMapping("/home/search")
	public ModelAndView search(@RequestParam(required = false) String catagoryID,
			@RequestParam(required = false) String keyword) {
		ModelAndView mv = new ModelAndView("home");
		List<VegetableDTO> listData = new ArrayList<VegetableDTO>();
		if (catagoryID != null && keyword == null) {
			listData = vegetableService.getVegetableByCatagoryID(catagoryID);
			System.out.print(1);
		} else if (catagoryID == null && keyword != null) {
			listData = vegetableService.getVegetableByVegetableName(keyword);
			System.out.print(2);
		} else if (catagoryID != null && keyword != null) {
			listData = vegetableService.getVegetableByCatagoryIDAndVegetableName(catagoryID, keyword);
			System.out.print(3);
		}
		List<CategoryDTO> listCategory = categoryService.getAllCategory();
		mv.addObject("listVegetable", listData);
		mv.addObject("listCategory", listCategory);
		return mv;
	}

	// trang sản phẩm bán chạy
	@GetMapping("/home/selling")
	public ModelAndView selling() {
		List<VegetableDTO> listData = vegetableService.getSellingVegetable();
		ModelAndView mv = new ModelAndView("selling");
		mv.addObject("listVegetable", listData);

		return mv;
	}

	// xem chi tiết sản phẩm
	@GetMapping("/vegetable/{id}")
	public ModelAndView detailProduct(@PathVariable Long id) {
		VegetableDTO dataDTO = vegetableService.getVegetableById(id);
		ModelAndView mv = new ModelAndView("detailProduct");
		mv.addObject("data", dataDTO);
		return mv;
	}
}
