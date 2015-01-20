package com.agamin.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.agamin.model.MenuModel;

@Component
public class CacheFactory {
	
	private static final String MENU_CACHE_NAME = "menuCache";
	
	@Autowired
	private CacheManager cacheManager;
	
	private AgaminCache<String, Map<String, MenuModel>> menuCache;
	
	public AgaminCache<String, Map<String, MenuModel>> getMenuCache() {
		if(menuCache == null) {
			Cache cache = cacheManager.getCache(MENU_CACHE_NAME);
			menuCache = new AgaminCache<String, Map<String,MenuModel>>(cache);
		}
		return menuCache;
	}

}
