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
		Customer result = null;
		if(isNotBlank(customer.getEmail())) {
			result = menuDao.getCustomerForEmail(customer.getEmail());
		}
		else if(isNotBlank(customer.getMobile())) {
			result = menuDao.getCustomerForMobile(customer.getMobile());
		}
		if(result == null) {
			menuDao.addCustomer(customer);
			result= customer;
		}
		return result;
	}

}
