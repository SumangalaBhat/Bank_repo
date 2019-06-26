package com.hcl.customer.serviceImpl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.hcl.customer.model.Customer;
import com.hcl.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	 HashMap<Long, Customer> hm = new HashMap<>();
	 Customer customer = new Customer();

	@Override
	public HashMap<Long, Customer> addCustomer(Customer customer) {
		hm.put(customer.getAccountNumber(), customer);
		return hm;

	}

	@Override
	public String updateCustomer(Customer customer, long accountNumber) {

		if (customer != null && hm.containsKey(accountNumber)) {
			hm.put(accountNumber, customer);
			return "Customer detils updated succesfully";
		} else {
			return "unable to update the data";
		}

	}

	@Override
	public Customer findCustomer(long accountNumber) {
		// HashMap<Long, Customer> hm= new HashMap<>();
		Customer customer = null;
		if (hm.containsKey(accountNumber)) {
			customer = hm.get(accountNumber);
		}

		return customer;
	}

	@Override
	public String deleteCustomer(long accountNumber) {
		Customer customer =null;
		if(hm.containsKey(accountNumber))
		{
			customer = hm.remove(accountNumber);
		}
		return "Sucessfully deleted";
	}
	
}
