package com.agamin.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.agamin.model.Asset;

@Repository
public class AssetDao {

	@Autowired
	private CassandraOperations template ;
	
	public Asset getAsset(UUID assetId) {
		List<Asset> result = template.select("select * from image where id=" +assetId , Asset.class);
		if(result.size() >0) {
			return result.get(0);
		}
		return null;
	}
	
	public Asset addAsset(Asset asset) {
		asset.setId(UUID.randomUUID());
		return template.insert(asset);
	}
	
}
