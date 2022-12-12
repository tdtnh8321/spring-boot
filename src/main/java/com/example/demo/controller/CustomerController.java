package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	//Mở Trang đăng ký
	@GetMapping("/user/register")
	public ModelAndView registerPage() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	// Tiến hành đăng ký
	@PostMapping(value = "/user/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int register(@RequestBody CustomerDTO dto) {
		String fullname = dto.getFullname();
		String username = dto.getUsername();
		String password = dto.getPassword();
		String repeatpassword = dto.getRepeatPassword();
		String address = dto.getAddress();
		String city = dto.getCity();
		//0:Password and Repeat Password phải giống nhau!!!
		//1:Không được để trống
		//2:Tên đăng nhập đã tồn tại
		//3:Đăng ký thành công
		if (!password.equals(repeatpassword)) {
			return 0;
		}
		if (fullname.equals("") || username.equals("") || password.equals("") || repeatpassword.equals("")
				|| address.equals("") || city.equals("")) {
			return 1;
		}
		if(!customerService.checkUsername(username)) {
			return 2;
		}
		customerService.createCustomer(dto);
		return 3;

	}

	//Mở Trang đăng nhập
	@GetMapping("/user/login")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	// Tiến hành đăng nhập
	@PostMapping(value = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int login(@RequestBody CustomerDTO dto, HttpSession session) {
		boolean checkLogin = customerService.checkLogin(dto);
		int result = 0;
		//0: thất bại; 1:thành công
		if (checkLogin) {
			CustomerDTO account = customerService.getAccount(dto);
			System.out.println(account.getCustomerID());
			System.out.println(account.getFullname());
			System.out.println(account.getAddress());
			System.out.println(account.getCity());
			result = 1;
			session.setAttribute("USER", account);
			System.out.println("Session: " + session.getAttribute("USER"));

		} else {
			result = 0;
		}
		return result;
	}
	// Đăng xuất
	@GetMapping("/user/logout")
	public void logout(HttpSession session, HttpServletResponse httpResponse) {
		session.removeAttribute("USER");
		try {
			httpResponse.sendRedirect("/home");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
