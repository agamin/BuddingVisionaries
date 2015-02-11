package com.agamin.service;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agamin.dao.CustomerDAO;
import com.agamin.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDao;
	
	public Customer getCustomer(Customer customer) {
		Customer result = null;
		if(isNotBlank(customer.getEmail())) {
			result = customerDao.getCustomerForEmail(customer.getEmail());
		}
		else if(isNotBlank(customer.getMobile())) {
			result = customerDao.getCustomerForMobile(customer.getMobile());
		}
		if(result == null) {
			customerDao.addCustomer(customer);
			result = customer;
		}
		return result;
	}

}
