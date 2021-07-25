package com.ameal.controller;

import com.ameal.domain.Customer;
import com.ameal.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;

//	@RequestMapping("/test")
//	public String test() {
//		return "test";
//	}

	/**
	 * 跳转到 input.jsp
	 */
	@RequestMapping("/input")
	public String input() {
		return "input";
	}

	/**
	 * 保存customer
	 */
	@RequestMapping("/save")
	public String save(Customer customer) {
		customerService.saveCustomer(customer);
		return "succ";
	}
}
