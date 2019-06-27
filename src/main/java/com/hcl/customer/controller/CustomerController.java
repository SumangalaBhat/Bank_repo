package com.hcl.customer.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.customer.model.Customer;
import com.hcl.customer.serviceImpl.CustomerServiceImpl;
@RestController
public class CustomerController {

		@Autowired
		CustomerServiceImpl customerServiceImpl;
		
		@PostMapping("/addCustomer")
		public ResponseEntity<HashMap<Long, Customer>> addCustomer(@RequestBody Customer customer) {
			HashMap<Long, Customer> cust =customerServiceImpl.addCustomer(customer);
			return new ResponseEntity<HashMap<Long, Customer>>(cust,HttpStatus.CREATED);
			//return cust;
			
		}
		@PutMapping("/updateCustomer/{accountNumber}")
		public ResponseEntity<String> updateCustomer(@RequestBody Customer customer,@PathVariable long accountNumber)
		{
			String cust =customerServiceImpl.updateCustomer(customer, accountNumber);
			
			return new ResponseEntity<String>(cust,HttpStatus.OK);
		}

		@GetMapping("/findByAccountNumber/{accountNumber}")
			public ResponseEntity<Customer> findCustomer(@PathVariable long accountNumber){
			Customer cust = customerServiceImpl.findCustomer(accountNumber);			
			return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		}
		@DeleteMapping("/deleteByAccountNumber/{accountNumber}")
		public ResponseEntity<String> deleteCustomer(@PathVariable long accountNumber){
			String cust =customerServiceImpl.deleteCustomer(accountNumber);			
			return new ResponseEntity<String>(cust,HttpStatus.OK);
		}
		}


	
	


