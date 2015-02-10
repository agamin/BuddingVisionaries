package com.agamin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.agamin.model.Menu;

@Repository
public class MenuDAO {
	
	@Autowired
	private CassandraOperations template ;

	public void getMenu(){
		List<Menu> results = template.select("select * from menu", Menu.class);
		for (Menu m : results) {
		  	System.out.println(" Name " + m.getName());
		  	System.out.println(" resturantCode "+ m.getPrimaryKey().getRestaurantCode());
		  }
	}
}
