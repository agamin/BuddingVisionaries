package com.agamin.controller;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.agamin.model.Customer;
import com.agamin.service.CustomerService;

public class CustomerControllerTest {

	@Mock
	private CustomerService service;
	
	@Mock
	private Customer customer;
	
    @InjectMocks private CustomerController target = new CustomerController();

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verifyGetCustomerEndPoint() throws Exception {
		target.getCustomer(customer);
		verify(service).getCustomer(customer);
	}
}
