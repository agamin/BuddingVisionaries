package com.agamin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agamin.cache.AgaminCache;
import com.agamin.cache.CacheFactory;
import com.agamin.dao.MenuDAO;
import com.agamin.model.Menu;

@Service
public class MenuService {

	@Autowired
	private CacheFactory cacheFactory;
	
	@Autowired
	private MenuDAO menuDao;
	
	public List<Menu> getMenu(String restaurantCode) {
		AgaminCache<String, List<Menu>> menuCache = cacheFactory.getMenuCache();
		return menuCache.get(restaurantCode);
	}

}
