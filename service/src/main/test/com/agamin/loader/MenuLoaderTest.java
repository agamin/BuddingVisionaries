package com.agamin.loader;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class MenuLoaderTest {

	@Mock
	private MenuDAO menuDAO;
	
	@Mock
	private CacheFactory cacheFactory;

	@Mock
	AgaminCache<String, List<Menu>> menuCache;

	@InjectMocks
	private MenuLoader target = new MenuLoader();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testLoad() throws Exception{
		when(cacheFactory.getMenuCache()).thenReturn(menuCache);
		List<Menu> menuList =Mockito.mock(List.class);
		Map<String,List<Menu>> menuMap=new HashMap<String, List<Menu>>();
		menuMap.put("1", menuList);
		when(menuDAO.getAllMenu()).thenReturn(menuMap);
		target.load();
		verify(menuCache).put("1",menuList);
	}
}
