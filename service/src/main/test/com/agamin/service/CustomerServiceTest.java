package com.agamin.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import com.agamin.dao.CustomerDAO;
import com.agamin.model.Customer;

public class CustomerServiceTest {

	@Mock
	private CustomerDAO dao;
	
    @InjectMocks private CustomerService target = new CustomerService();
    
    @Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
    
    @Test
    public void getExistingCustomerRegisteredViaEmail(){
    	Customer customer=new Customer();
    	customer.setEmail("email");
    	target.getCustomer(customer);
    	verify(dao).getCustomerForEmail("email");
    	verify(dao,never()).getCustomerForMobile("mobile");
    }
    
    @Test
    public void getExistingCustomerRegisteredViaMobile(){
    	Customer customer=new Customer();
    	customer.setMobile("mobile");
    	target.getCustomer(customer);
    	verify(dao,never()).getCustomerForEmail("email");
    	verify(dao).getCustomerForMobile("mobile");
    }
    
    @Test
    public void getCustomerForNewCustomer(){
    	Customer customer=new Customer();
    	target.getCustomer(customer);
    	verify(dao,never()).getCustomerForEmail("email");
    	verify(dao,never()).getCustomerForMobile("mobile");
    	verify(dao).addCustomer(customer);
    }
}
