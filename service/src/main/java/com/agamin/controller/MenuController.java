package com.agamin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agamin.model.Customer;
import com.agamin.model.Menu;
import com.agamin.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	
	@Autowired
	private MenuService service;
	
	@RequestMapping(value="/getAllMenu", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Menu> reloadDealerInfo(@PathVariable String restaurantCode) {
		return service.getMenu(restaurantCode);
	}
	
	@RequestMapping(value="/getCustomer", method=RequestMethod.GET)
	@ResponseBody
	public Customer getCustomer(@ModelAttribute Customer customer) {
		return service.getCustomer(customer);
	}
	
	@RequestMapping(value="/status", method=RequestMethod.GET)
	@ResponseBody
	public String check() {
		return "OK";
	}

}
