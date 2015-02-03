package com.agamin.service;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agamin.cache.AgaminCache;
import com.agamin.cache.CacheFactory;
import com.agamin.dao.MenuDAO;
import com.agamin.model.Customer;
import com.agamin.model.Menu;

@Service
public class MenuService {

	@Autowired
	private CacheFactory cacheFactory;
	
	@Autowired
	private MenuDAO menuDao;
	
	public Map<String, Menu> getMenu(String restaurantCode) {
		AgaminCache<String, Map<String, Menu>> menuCache = cacheFactory.getMenuCache();
		return menuCache.get(restaurantCode);
	}

	public Customer getCustomer(Customer customer) {
		
		if(isNotBlank(customer.getEmail())) {
			return menuDao.getCustomer(customer.getEmail());
		}
		if(customer.getMobile() != null && customer.getMobile().doubleValue() > 0) {
			return menuDao.getCustomer(customer.getMobile());
		}
		menuDao.addCustomer(customer);
		return customer;
	}

}
