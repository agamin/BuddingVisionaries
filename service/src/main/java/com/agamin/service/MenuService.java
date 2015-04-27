package com.agamin.service;

import java.util.Arrays;
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

	public String addItem(Menu[] menuItems) {
		List<Menu> items = menuItems != null ? Arrays.asList(menuItems) : null;
		if (validateMenuItem(items)) {
			menuDao.insertMenuItem(items);
			return "success";
		} else {
			return "fail";
		}
	}
	
	protected boolean validateMenuItem(List<Menu> items) {
		if (items != null && items.size() > 0) {
			return true;
		}
		for(Menu item: items){
			if(item.getPrimaryKey().getRestaurantCode() == null){
				return false;
			}
		}
		return false;
	}

	public String updateItem(Menu[] menuItems) {
		// TODO Auto-generated method stub
		List<Menu> items = menuItems != null ? Arrays.asList(menuItems) : null;
		if (validateMenuItem(items)) {
			menuDao.updateMenuItem(items);
			return "success";
		} else {
			return "fail";
		}
	}

	public String bulkAddition(String str) {
        return "test    " + str    ;
	}

	/*public String deleteItem(Menu[] menuItems) {
		// TODO Auto-generated method stub
		List<Menu> items = menuItems != null ? Arrays.asList(menuItems) : null;
		if (validateMenuItem(items)) {
			menuDao.deleteMenuItem(items);
			return "success";
		} else {
			return "fail";
		}
	}*/

}
