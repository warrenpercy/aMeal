package com.ameal.test;

import com.ameal.dao.CustomerMapper;
import com.ameal.domain.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
	@Test
	public void Test() throws IOException {
		//1.创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		//加载sqlMapConfig.xml文件
		InputStream is = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");

		//2.创建sqlSessionFactory
		SqlSessionFactory factory = builder.build(is);

		//3.打开SqlSession
		SqlSession sqlSession = factory.openSession();

		//4.获取Mapper接口对象
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

		//5.操作
		Customer customer = new Customer();
		customer.setName("小张");
		customer.setGender("男");
		customer.setTelephone("020-33333333");
		customer.setAddress("北京青鸟");

		customerMapper.saveCustomer(customer);

		//6.事务
		sqlSession.commit();

		//7.关闭
		sqlSession.close();
	}

	@Test
	public void test01() {
		// 1. 加载spring配置
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		// 2. 获取对象
		CustomerMapper customerMapper = (CustomerMapper) ac.getBean("customerMapper");

		// 3. 调用saveCustomer方法
		Customer customer = new Customer();
		customer.setName("小妹");
		customer.setGender("女");
		customer.setTelephone("020-666666");
		customer.setAddress("北京青鸟");

		customerMapper.saveCustomer(customer);

	}

	@Test
	public void test02() {
		// 1. 加载spring配置
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		// 2. 获取对象
		CustomerMapper customerMapper = (CustomerMapper) ac.getBean("customerMapper");

		// 3. 调用saveCustomer方法
		Customer customer = new Customer();
		customer.setName("老王");
		customer.setGender("男");
		customer.setTelephone("020-88888888");
		customer.setAddress("北京青鸟");

		customerMapper.saveCustomer(customer);
	}

	@Test
	public void test03() {
		// 1. 加载spring配置
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		// 2. 获取对象
		CustomerMapper customerMapper = (CustomerMapper) ac.getBean("customerMapper");

		// 3. 调用saveCustomer方法
		Customer customer = new Customer();
		customer.setName("老李");
		customer.setGender("男");
		customer.setTelephone("020-77777777");
		customer.setAddress("清华紫光");

		customerMapper.saveCustomer(customer);
	}
}
