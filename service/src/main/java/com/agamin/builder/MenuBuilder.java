package com.agamin.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agamin.dao.MenuDAO;
import com.agamin.model.Menu;

@Component
public class MenuBuilder {

	@Autowired
	private MenuDAO menuDao;

	public List<Menu> getAllMenu() {
		//Get the menus from DAO.
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu = new Menu();
		menu.setName("ice-cream");
		menus.add(menu);
		return menus;
	}
}
