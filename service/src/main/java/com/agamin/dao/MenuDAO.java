package com.agamin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agamin.model.Menu;

@Repository
public class MenuDAO {
	
	@Autowired
	static DBConnection connection ;

	/*public static void main(String[] str){
		List<Menu> results = connection.getConnection().select("select * from menu", Menu.class);
		for (Menu m : results) {
		  	System.out.println(" Name " + m.getName());
		  	System.out.println(" resturantCode "+ m.getPrimaryKey().getRestaurantCode());
		  }
	}*/
	public void getMenu(){
		List<Menu> results = connection.getConnection().select("select * from menu", Menu.class);
		for (Menu m : results) {
		  	System.out.println(" Name " + m.getName());
		  	System.out.println(" resturantCode "+ m.getPrimaryKey().getRestaurantCode());
		  }
	}
}
