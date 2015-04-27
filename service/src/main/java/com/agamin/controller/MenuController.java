package com.agamin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.agamin.model.Menu;
import com.agamin.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@RequestMapping(value="/getMenu/{restaurantCode}", method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> reloadDealerInfo(@PathVariable String restaurantCode) {
		return service.getMenu(restaurantCode);
	}
	
	
	 
     // Add a new single or multiple item in menu.
     
    @RequestMapping(value = "/getMenu/addItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String addItems(@RequestBody final Menu[] menuItem) {
        return service.addItem(menuItem) ;
    }
    @RequestMapping(value = "/getMenu/updateItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String updateItems(@RequestBody final Menu[] menuItem) {
        return service.updateItem(menuItem) ;
    }
  /*  @RequestMapping(value = "/getMenu/deleteItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String deleteItems(@RequestBody final Menu[] menuItem) {
        return service.deleteItem(menuItem) ;
    }*/
	
    @RequestMapping(value = "/getMenu/addBulkItem", method = RequestMethod.POST)
    @ResponseBody
    public  String addBulkItem(@RequestParam("file") MultipartFile file) {
    	if(file.isEmpty()){
    		return "fail";
    	}
    	String str = file.getName();
        return service.bulkAddition(str);
    }
    
	@RequestMapping(value="/status", method=RequestMethod.GET)
	@ResponseBody
	public String check() {
		return "OK";
	}

}
