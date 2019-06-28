package com.hcl.customer.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.customer.exception.DataNotFoundException;
import com.hcl.customer.model.Address;
import com.hcl.customer.model.Customer;
import com.hcl.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	public static HashMap<Long, Customer> hm = new HashMap<>();

	static Customer customer = new Customer();
	/*
	 * ObjectMapper om= new ObjectMapper(); TypeReference<HashMap<Long, Customer>>
	 * typeReference = new TypeReference<HashMap<Long,Customer>>() { }; InputStream
	 * inputStream = TypeReference.class.getResourceAsStream("static/customer.json")
	 * hm = om.readValue(inputStream, typeReference);
	 */
	
	
	
	static {
		Address official= new Address();
		official.setCity("mangalore");
		official.setPincode(574239);
		official.setState("karnataka");
		official.setTypeOfAddress("office Address");
		
		Address res= new Address();
		res.setCity("bangaloru");
		res.setPincode(561000);
		res.setState("karnataka");
		res.setTypeOfAddress("residencial Address");
		
		List<Address> listadd = new ArrayList<Address>();
		
		listadd.add(official);
		listadd.add(res);
		
		
		Customer cust1 = new Customer();
		cust1.setAccountNumber(1234l);
		cust1.setCustMobNum(2345);
		cust1.setCustName("name1");
		cust1.setCustRole("custRole1");
		cust1.setAddress(listadd);
		
	}
	
	@Override
	public HashMap<Long, Customer> addCustomer(Customer customer) {
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
		Customer customer = null;
		if (hm.containsKey(accountNumber)) {
			customer = hm.remove(accountNumber);
			return "Sucessfully deleted";
		}

		else {
			throw new DataNotFoundException("No Record Avaliable");
		}
	}

}
