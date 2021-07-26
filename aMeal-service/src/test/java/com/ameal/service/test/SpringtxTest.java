package com.ameal.service.test;

import com.ameal.dao.CustomerMapper;
import com.ameal.domain.Customer;
import com.ameal.service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringtxTest {

	@Test
	public void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-tx.xml");
		CustomerService customerService = (CustomerService) ac.getBean("customerService");
		CustomerMapper customerMapper = (CustomerMapper) ac.getBean("customerMapper");

		Customer customer = new Customer();
		customer.setName("老郭");
		customer.setGender("男");
		customer.setTelephone("020-5555555");
		customer.setAddress("清华紫光");

		customerService.saveCustomer(customer);
	}
}
