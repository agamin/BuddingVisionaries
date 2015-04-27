package com.agamin.controller;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.agamin.model.Asset;
import com.agamin.service.AssetService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AssetControllerTest {
	
	@Mock
	private AssetService service;
	
	@Mock
	private Asset asset;
	
	UUID uuid=UUID.randomUUID();
	
    @InjectMocks private AssetController target = new AssetController();

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verifyGetAssetEndPoint() throws Exception {
		when(asset.getId()).thenReturn(uuid);
		target.getAsset(asset);
		verify(service).getAsset(uuid);
	}
	
	@Test
	public void verifyAddAssetEndPoint() throws Exception {
		target.addAsset(asset);
		verify(service).addAsset(asset);
	}
	
}
