package com.ameal.service.Impl;

import com.ameal.dao.CustomerMapper;
import com.ameal.domain.Customer;
import com.ameal.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	// 注入mapper对象
	@Resource
	private CustomerMapper customerMapper;

	@Override
	public void saveCustomer(Customer customer) {
		customerMapper.saveCustomer(customer);

		// 模拟异常
//		int i = 100/0;
//		customerMapper.saveCustomer(customer);
	}
}
