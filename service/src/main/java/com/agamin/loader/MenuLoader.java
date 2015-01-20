package com.agamin.loader;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agamin.builder.MenuBuilder;
import com.agamin.model.MenuModel;

@Component
public class MenuLoader {
	
	@Autowired
	private MenuBuilder menuBuilder;
	
	//private MenuCache menuCache;
	
	@PostConstruct
	public void load() {
		List<MenuModel> menus = menuBuilder.getAllMenu();
		for (MenuModel menu : menus) {
			//menuCache.put(menu.getName(), menu);
		}
		
	}

}
