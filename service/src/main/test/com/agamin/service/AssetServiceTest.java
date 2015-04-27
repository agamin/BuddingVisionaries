package com.agamin.service;

import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.agamin.dao.AssetDao;
import com.agamin.model.Asset;


public class AssetServiceTest {
	
	@Mock
	private AssetDao dao;
	
    @InjectMocks private AssetService target = new AssetService();
    
	UUID actual = UUID.randomUUID();

    @Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
    
	@Test
	public void addAsset() {
		Asset asset = new Asset();
		asset.setBranchCode("brCode");
		asset.setId(actual);
		when(dao.addAsset(asset)).thenReturn(asset);
		UUID expected = target.addAsset(asset);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void getAsset() {
	//Get asset to go here
	}
}
