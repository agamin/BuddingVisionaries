package com.agamin.loader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agamin.builder.MenuBuilder;
import com.agamin.cache.AgaminCache;
import com.agamin.cache.CacheFactory;
import com.agamin.model.Menu;

@Component
public class MenuLoader {
	
	@Autowired
	private MenuBuilder menuBuilder;
	
	@Autowired
	private CacheFactory cacheFactory;
	
	//@PostConstruct
	public void load() {
		AgaminCache<String, Map<String, Menu>> menuCache = cacheFactory.getMenuCache();
		List<Menu> menus = menuBuilder.getAllMenu();
		for (Menu menu : menus) {
			menuCache.put("ReataurantId", new HashMap<String, Menu>());//Change
		}
		
	}

}
