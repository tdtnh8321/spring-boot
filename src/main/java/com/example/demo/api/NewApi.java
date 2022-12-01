package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderDetailDTO;
//import com.example.demo.dto.CategoryDTO;
//import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.VegetableDTO;
import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.VegetableService;

//import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
@RestController
public class NewApi {

	private final VegetableService vegetableService;
	private final CategoryService categoryService;
	private final CustomerService customerService;
	private final OrderService orderService;
	private final OrderDetailService orderDetailService;

	@Autowired
	public NewApi(VegetableService vegetableService, CategoryService categoryService, CustomerService customerService,OrderService orderService,OrderDetailService orderDetailService) {
		this.vegetableService = vegetableService;
		this.categoryService = categoryService;
		this.customerService = customerService;
		this.orderService=orderService;
		this.orderDetailService=orderDetailService;
	}

	// ------------------Test api--------------
	@GetMapping("/test")
	public String testAPI() {

		return "success";
	}

	@GetMapping("/api/vegetable")
	public List<VegetableDTO> getAllVegetables() {
		return vegetableService.getAllVegetables();
	}

	@GetMapping("/api/vegetable/search")
	public List<VegetableDTO> getVegetablesBySearch(@RequestParam String catagoryID) {
		return vegetableService.getVegetableByCatagoryID(catagoryID);
	}

	@GetMapping("/api/vegetable/{id}")
	public VegetableDTO getVegetableById(@PathVariable Long id) {
		return vegetableService.getVegetableById(id);
	}

	@GetMapping("/api/vegetable/selling")
	public List<VegetableDTO> getSellingVegetable() {
		return vegetableService.getSellingVegetable();
	}
	@GetMapping("/api/order")
	public List<OrderDTO> getListOrder(){
		return orderService.getListOrder();
	}
	@GetMapping("/api/orderdetail")
	public List<OrderDetailDTO> getListOrderDetail(){
		return orderDetailService.getList();
	}
}
