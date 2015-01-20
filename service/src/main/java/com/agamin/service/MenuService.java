package com.agamin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agamin.cache.AgaminCache;
import com.agamin.cache.CacheFactory;
import com.agamin.model.Menu;

@Service
public class MenuService {

	@Autowired
	private CacheFactory cacheFactory;
	
	public Map<String, Menu> getMenu(String restaurantCode) {
		AgaminCache<String, Map<String, Menu>> menuCache = cacheFactory.getMenuCache();
		return menuCache.get(restaurantCode);
	}

}
