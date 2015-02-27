package com.agamin.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agamin.model.Asset;
import com.agamin.service.AssetService;

@Controller
@RequestMapping("/asset")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	@RequestMapping(value="/getAsset", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getAsset(Asset asset) {
		return assetService.getAsset(asset.getId());
	}
	
	@RequestMapping(value="/addAsset", method=RequestMethod.GET)
	@ResponseBody
	public UUID addAsset(Asset asset) throws IOException {
		return assetService.addAsset(asset);
	}

}
