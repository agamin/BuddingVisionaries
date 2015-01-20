package com.agamin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agamin.cache.AgaminCache;
import com.agamin.cache.CacheFactory;
import com.agamin.model.MenuModel;

@Service
public class MenuService {

	@Autowired
	private CacheFactory cacheFactory;
	
	public Map<String, MenuModel> getMenu(String restaurantCode) {
		AgaminCache<String, Map<String, MenuModel>> menuCache = cacheFactory.getMenuCache();
		return menuCache.get(restaurantCode);
	}

}
