package com.ameal.dao;

import com.ameal.domain.Customer;

public interface CustomerMapper {
	/**
	 * 添加用户
	 * @param customer
	 */
	public void saveCustomer(Customer customer);
}
