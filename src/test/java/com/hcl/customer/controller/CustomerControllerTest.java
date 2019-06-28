package com.hcl.customer.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.customer.model.Customer;
import com.hcl.customer.serviceImpl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	MockMvc mockMvc;
	
	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerServiceImpl customerServiceImpl;
	
	private Customer customer;
	HashMap<Long,Customer> hashMap;
	
	
	@Before
	public void setUp() {

		customer = new Customer();
		hashMap = new HashMap<Long,Customer>();
		hashMap.put(customer.getAccountNumber(), customer);
		this.mockMvc= MockMvcBuilders.standaloneSetup(customerController).build();
	}
	
	@Test
	public void addCustomer() throws JsonProcessingException, Exception
	{
	when(customerServiceImpl.addCustomer(customer)).thenReturn(hashMap);
	mockMvc.perform(post("/addCustomer").contentType(MediaType.APPLICATION_JSON)
			.content(jsonToString(customer))).andExpect(status().isCreated()).andDo(print());
	ResponseEntity<HashMap<Long, Customer>> actualResult = customerController.addCustomer(customer);
	//assertEquals(hashMap.get(customer.getAccountNumber()).getCustName(), actualResult.get(customer.getAccountNumber()).getCustName());
	
	}
	
	private String jsonToString(final Object ob) throws JsonProcessingException {
		String result;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonContent = mapper.writeValueAsString(ob);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			result = "JSON Processing error";
		}
		return result;
	}

	

}
