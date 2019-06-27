package com.hcl.customer.service;

import java.util.HashMap;

import com.hcl.customer.model.Customer;

public interface CustomerService {
		
		public HashMap<Long, Customer> addCustomer(Customer customer);
		
		public String updateCustomer(Customer customer, long accountNumber);
		public Customer findCustomer(long accountNumber);
		public String  deleteCustomer(long accountNumber );

	}

