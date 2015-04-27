package com.agamin.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import com.agamin.model.Menu;
import com.agamin.service.MenuService;
public class MenuControllerTest {
	
	@Mock
	private MenuService service;
	
    @InjectMocks private MenuController target = new MenuController();

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verifyStatus() throws Exception {
		assertEquals("OK",target.check());
	}
	
	@Test
	public void verifyAddItemEndPoint() throws Exception {
		Menu[] menuArr=getMenuArray();
		target.addItems(menuArr);
		verify(service).addItem(menuArr);
	}
	
	@Test
	public void verifyReloadEndPoint() throws Exception {
		String restaurantCode="12345";
		target.reloadDealerInfo(restaurantCode);
		verify(service).getMenu(restaurantCode);
	}
	
	@Test
	public void verifyUpdateItemEndPoint() throws Exception {
		Menu[] menuArr=getMenuArray();
		target.updateItems(menuArr);
		verify(service).updateItem(menuArr);
	}
	
	@Test
	public void verifyAddBulkItemEndPointSucces() throws Exception {
		MultipartFile file=Mockito.mock(MultipartFile.class);
		when(file.isEmpty()).thenReturn(false);
		when(file.getName()).thenReturn("bulk.csv");
		target.addBulkItem(file);
		verify(service).bulkAddition("bulk.csv");
	}
	
	@Test
	public void verifyAddBulkItemEndPointFaliure() throws Exception {
		MultipartFile file=Mockito.mock(MultipartFile.class);
		when(file.isEmpty()).thenReturn(true);
		when(file.getName()).thenReturn("bulk.csv");
		target.addBulkItem(file);
		verify(service, Mockito.times(0)).bulkAddition("bulk.csv");
	}
	
	public Menu[] getMenuArray(){
		Menu menu1=new Menu();
		menu1.setBranchCode("123");
		Menu menu2=new Menu();
		menu2.setBranchCode("234");
        return new Menu[]{menu1,menu2};
	}

}
