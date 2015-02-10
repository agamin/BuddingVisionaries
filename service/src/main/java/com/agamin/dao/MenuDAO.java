package com.agamin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.agamin.model.Menu;

@Repository
public class MenuDAO {
	
	@Autowired
	private CassandraOperations template ;

	public Map<String ,List<Menu>> getAllMenu(){
		
		List<Menu> results = template.select("select * from menu", Menu.class);
		
		Map<String ,List<Menu>> menuMap = new HashMap<String ,List<Menu>>();
		
		for (Menu menu : results) {
			
			String restaurantCode = menu.getPrimaryKey().getRestaurantCode();
			
			if (menuMap.get(restaurantCode) == null) {
				menuMap.put(restaurantCode, new ArrayList<Menu>());
			}
			List<Menu> menuList = menuMap.get(restaurantCode);
			menuList.add(menu);
		}
		
		return menuMap;
	}
}
