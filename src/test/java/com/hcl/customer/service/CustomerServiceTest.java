package com.hcl.customer.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.customer.model.Customer;
import com.hcl.customer.serviceImpl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	//@Mock
	//CustomerServiceImpl customerServiceImpl1;

	@Autowired
	private Customer customer;
	HashMap<Long, Customer> hashMap;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customer = new Customer();
		hashMap = new HashMap<Long, Customer>();
		hashMap.put(customer.getAccountNumber(), customer);

	}

	@After
	public void tearDown() {
		customer = null;
	}

	@Test
	public void addCustomer() {

		// long accountNumber= 1234L;
		// Customer customer1 = new Customer("yyyy", 57657657, 65656, "dfg");
		customer.setAccountNumber(1234l);
		customer.setCustMobNum(9876);
		customer.setCustName("custName");
		hashMap.put(customer.getAccountNumber(), customer);
		when(customerServiceImpl.addCustomer(any())).thenReturn(hashMap);
		HashMap<Long, Customer> fetched = customerServiceImpl.addCustomer(customer);
		// assertEquals(hashMap,fetched);
		System.out.println(fetched);
		System.out.println(hashMap);
		assertEquals(fetched.get(1234l).getCustName(), hashMap.get(1234l).getCustName());
	}

}