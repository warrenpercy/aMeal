package com.ameal.dao.impl;

import com.ameal.dao.CustomerMapper;
import com.ameal.domain.Customer;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CustomerMapperImpl extends SqlSessionDaoSupport implements CustomerMapper {
	@Override
	public void saveCustomer(Customer customer) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("saveCustomer", customer);
		// 这里不需要事务的提交
	}
}
