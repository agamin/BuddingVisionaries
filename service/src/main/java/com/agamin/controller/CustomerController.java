package com.agamin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agamin.model.Customer;
import com.agamin.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping(value="/getCustomer", method=RequestMethod.GET)
	@ResponseBody
	public Customer getCustomer(@ModelAttribute Customer customer) {
		return service.getCustomer(customer);
	}

}
