package com.hcl.customer.json;

import com.hcl.customer.model.Customer;

public class JsonConverter {

	
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
		//hm.put(cust1.getAccountNumber(), cust1);
		//hm.put(cust2.getAccountNumber(), cust2);
	}
}
