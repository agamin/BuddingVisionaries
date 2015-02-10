package com.agamin.loader;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agamin.cache.AgaminCache;
import com.agamin.cache.CacheFactory;
import com.agamin.dao.MenuDAO;
import com.agamin.model.Menu;

@Component
public class MenuLoader {
	
	@Autowired
	private MenuDAO menuDao;
	
	@Autowired
	private CacheFactory cacheFactory;
	
	@PostConstruct
	public void load() {
		
		Map<String, List<Menu>> menus = menuDao.getAllMenu();
		AgaminCache<String, List<Menu>> menuCache = cacheFactory.getMenuCache();
		Map<String, List<Menu>> menuMap = menuDao.getAllMenu();
		for (String restaurantCode : menuMap.keySet()) {
			menuCache.put(restaurantCode, menuMap.get(restaurantCode));
		}
	}

}
