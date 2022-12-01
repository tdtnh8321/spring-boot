package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.*;
import com.example.demo.service.*;


@RestController
public class ShoppingCartController {
	private final VegetableService vegetableService;
	private final ShoppingCartService shoppingCartService;
	private final OrderService orderService;
	private final OrderDetailService orderDetailService;
	@Autowired
	public ShoppingCartController(VegetableService vegetableService, 
			ShoppingCartService shoppingCartService,
			OrderService orderService,
			OrderDetailService orderDetailService) {
		this.vegetableService = vegetableService;
		this.shoppingCartService = shoppingCartService;
		this.orderService=orderService;
		this.orderDetailService=orderDetailService;

	}

	// cart
	@GetMapping("/cart")
	public ModelAndView cartPage(HttpSession session) {
		session.setAttribute("CART", shoppingCartService.getAllItems());
		session.setAttribute("CART_COUNT", shoppingCartService.getCount());
		session.setAttribute("CART_TOTAL_AMOUNT", shoppingCartService.getTotalAmount());
		ModelAndView mv = new ModelAndView("cart");
		return mv;
	}

	// them 1 sp
	@GetMapping("/add/{id}")
	public int addItem(@PathVariable Long id, @RequestParam(required = false) int qty) {
		int result = 0;// 0:thất bại,1:thành công
		VegetableDTO vegetableDTO = vegetableService.getVegetableById(id);
		if (vegetableDTO != null) {
			CartItemDTO item = new CartItemDTO();
			item.setVegetableID(vegetableDTO.getVegetableID());
			item.setVegetableName(vegetableDTO.getVegetableName());
			item.setImage(vegetableDTO.getImage());
			item.setPrice(vegetableDTO.getPrice());
			item.setQty(qty);
			int check = shoppingCartService.addOne(item);
			if (check == 1) {
				result = 1;
			} else if (check == 0) {
				result = 0;
			}

		} else {
			result = 0;
		}

		return result;
	}

	// giam sl di 1
	@GetMapping("/reduce/{id}")
	public int reduceItem(@PathVariable Long id) {
		int result = 0;// 0:thất bại,1:thành công
		VegetableDTO vegetableDTO = vegetableService.getVegetableById(id);
		if (vegetableDTO != null) {

			shoppingCartService.reduceOne(id);
			result = 1;
		} else {
			result = 0;
		}

		return result;
	}

	// xoa sp ra koi gio
	@GetMapping("/remove/{id}")
	public int removeItem(@PathVariable Long id) {
		int result = 0;// 0:thất bại,1:thành công
		VegetableDTO vegetableDTO = vegetableService.getVegetableById(id);
		if (vegetableDTO != null) {
			shoppingCartService.removeItem(id);
			result = 1;
		} else {
			result = 0;
		}

		return result;
	}

	// kiểm tra truy cập checkout
	@GetMapping("/checkout")
	public int checkLoginBeforCheckout(HttpSession session) {
		// 0:thất bại,1:thành công
		if (session.getAttribute("USER") != null) {
			return 1;
		} else {
			return 0;
		}
	}

	// trang checkout
	@GetMapping("/user/checkout")
	public ModelAndView checkoutPage() {
		ModelAndView mv = new ModelAndView("checkout");
		return mv;
	}

	// tiến hành đặt hàng
	@PostMapping(value = "/user/checkout", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int checkout(HttpSession session, @RequestBody OrderDTO dto) {

		CustomerDTO customerDTO = (CustomerDTO) session.getAttribute("USER");
		System.out.println("cusID: "+customerDTO.getCustomerID());
		System.out.println("date: "+dto.getDate());
		System.out.println("total: "+dto.getTotal());
		System.out.println("note: "+dto.getNote());
		
		//Lưu order và trả lại orderID
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setCustomerID(customerDTO.getCustomerID());
		orderDTO.setDate(dto.getDate());
		orderDTO.setNote(dto.getNote());
		orderDTO.setTotal(dto.getTotal());
		Long idOrder = orderService.createNewOrder(orderDTO);
		System.out.println("Id order: "+idOrder);
		
		//Lưu các orderDetail
		//OrderID,VegetableID,Quantity,Price
		Collection<CartItemDTO> listItem = shoppingCartService.getAllItems();
		List<OrderDetailDTO> listOrderDetail = new ArrayList<OrderDetailDTO>();
		for(CartItemDTO item : listItem) {
			OrderDetailDTO odDTO = new OrderDetailDTO();
			odDTO.setOrderID(idOrder);
			odDTO.setVegetableID(item.getVegetableID());
			odDTO.setQuantity(item.getQty());
			odDTO.setPrice(item.getPrice());
			listOrderDetail.add(odDTO);
		}
		orderDetailService.addListOrderDetail(listOrderDetail);
		
		//Giam sl 
		List<VegetableDTO> listVegetableDTO = new ArrayList<VegetableDTO>();
		for(CartItemDTO item : listItem) {
			VegetableDTO vegetableDTO= new VegetableDTO();
			vegetableDTO.setVegetableID(item.getVegetableID());
			vegetableDTO.setAmount(item.getQty());
			listVegetableDTO.add(vegetableDTO);
		}
		vegetableService.updateQty(listVegetableDTO);
		
		//Xoa gio hang
		shoppingCartService.clear();
		return 1;
	}
}
