package com.agamin.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.agamin.cache.AgaminCache;
import com.agamin.cache.CacheFactory;
import com.agamin.dao.MenuDAO;
import com.agamin.model.Menu;

public class MenuServiceTest {

	@Mock
	private MenuDAO dao;
	
	@Mock
	CacheFactory cacheFactory;

	@Mock
	AgaminCache<String, List<Menu>> menuCache;
	
	UUID uuid=UUID.randomUUID();
	
    @InjectMocks private MenuService target = new MenuService(){
    	protected boolean validateMenuItem(java.util.List<Menu> items) {
    		return true;
    	};
    };

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verifyGetMenu() throws Exception {
		when(cacheFactory.getMenuCache()).thenReturn(menuCache);
		target.getMenu("restCode");
		verify(menuCache).get("restCode");
	}
	
	@Test
	public void verifyAddMenuSuccess() throws Exception {
		Menu[] menuArray=getMenuArray();
		target.addItem(menuArray);
		verify(dao).insertMenuItem(Arrays.asList(menuArray));
	}
	
	@Test
	public void verifyAddMenuFailure() throws Exception {
		//Failure case to go here
	}
	
	@Test
	public void verifyUpdateMenuSuccess() throws Exception {
		Menu[] menuArray=getMenuArray();
		target.updateItem(menuArray);
		verify(dao).updateMenuItem(Arrays.asList(menuArray));
	}
	
	Menu[] getMenuArray(){
		Menu[] menuArray= new Menu[2];
		menuArray[0]=Mockito.mock(Menu.class);
		menuArray[1]=Mockito.mock(Menu.class);
		return menuArray;
	}
}
