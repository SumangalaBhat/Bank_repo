package com.hcl.customer.serviceImpl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.hcl.customer.exception.DataNotFoundException;
import com.hcl.customer.model.Customer;
import com.hcl.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	 public static HashMap<Long, Customer> hm = new HashMap<>();
	
	 static Customer customer = new Customer( );
	 
	
	
	static {
		Customer cust1 = new Customer();
		cust1.setAccountNumber(1234l);
		cust1.setCustMobNum(2345);
		cust1.setCustName("name1");
		cust1.setCustRole("custRole1");
		/*
		 * Customer cust2 = new Customer(); cust2.setAccountNumber(453l);
		 * cust2.setCustMobNum(567); cust2.setCustName("name2");
		 * cust2.setCustRole("custRole2");
		 */
		hm.put(cust1.getAccountNumber(), cust1);
		//hm.put(cust2.getAccountNumber(), cust2);
	}
	 
	 
	 
	@Override
	public  HashMap<Long, Customer> addCustomer(Customer customer) {
		hm.put(customer.getAccountNumber(), customer);
		System.out.println(hm);
		return hm;

	}

	@Override
	public String updateCustomer(Customer customer, long accountNumber) {

		if (customer != null && hm.containsKey(accountNumber)) {
			hm.put(accountNumber, customer);
			return "Customer detils updated succesfully";
		} else {
			throw new DataNotFoundException("No Record Avaliable");
		}

	}

	@Override
	public Customer findCustomer(long accountNumber) {
		// HashMap<Long, Customer> hm= new HashMap<>();
		Customer customer = null;
		if (hm.containsKey(accountNumber)) {
			customer = hm.get(accountNumber);
			return customer;
		}

		else {
			throw new DataNotFoundException("No Record Avaliable");
		}
	}

	@Override
	public String deleteCustomer(long accountNumber) {
		Customer customer =null;
		if(hm.containsKey(accountNumber))
		{
			customer = hm.remove(accountNumber);
			return "Sucessfully deleted";
		}
		
		else
		{
			throw new DataNotFoundException("No Record Avaliable");
		}
	}
	
}
