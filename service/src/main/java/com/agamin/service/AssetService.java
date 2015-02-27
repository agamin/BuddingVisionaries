package com.agamin.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agamin.dao.AssetDao;
import com.agamin.model.Asset;

@Service
public class AssetService {
	
	@Autowired
	private AssetDao assetDao;
	
	public byte[] getAsset(UUID assetId) {
		Asset asset = assetDao.getAsset(assetId);
		byte[] data = new byte[asset.getContent().remaining()];
		asset.getContent().get(data);
		return data;
	}
	
	public UUID addAsset(Asset asset) {
		return assetDao.addAsset(asset).getId();
	}
	

}
