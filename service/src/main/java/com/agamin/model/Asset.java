package com.agamin.model;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="image")
public class Asset {
	
	@PrimaryKey
	private UUID id;
	
	@Column(value="branch_code")
	private String branchCode;
	
	private ByteBuffer content;
	
	@Column(value="menu_id")
	private int menuId;
	
	@Column(value="restaurant_code")
	private String restaurantCode;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public ByteBuffer getContent() {
		return content;
	}

	public void setContent(ByteBuffer content) {
		this.content = content;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getRestaurantCode() {
		return restaurantCode;
	}

	public void setRestaurantCode(String restaurantCode) {
		this.restaurantCode = restaurantCode;
	}
	
	

}
