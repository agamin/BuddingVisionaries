package com.agamin.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agamin.dao.MenuDAO;
import com.agamin.model.MenuModel;

@Component
public class MenuBuilder {

	@Autowired
	private MenuDAO menuDao;

	public List<MenuModel> getAllMenu() {
		//Get the menus from DAO.
		List<MenuModel> menus = new ArrayList<MenuModel>();
		MenuModel menu = new MenuModel();
		menu.setName("ice-cream");
		menus.add(menu);
		return menus;
	}
}
