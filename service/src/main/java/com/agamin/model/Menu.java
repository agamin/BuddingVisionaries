package com.agamin.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private PrimaryKeyClass primaryKey;
	private String category;
	private int chillyRating;
	private String cuisine;
	private String description;
	private List<String> mealType;
	private String name;
	private String picture;
	private Double price;
	private List<String> tag;
	private String veg;

	public PrimaryKeyClass getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(PrimaryKeyClass primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getChillyRating() {
		return chillyRating;
	}

	public void setChillyRating(int chillyRating) {
		this.chillyRating = chillyRating;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getMealType() {
		return mealType;
	}

	public void setMealType(List<String> mealType) {
		this.mealType = mealType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getVeg() {
		return veg;
	}

	public void setVeg(String veg) {
		this.veg = veg;
	}

	@org.springframework.data.cassandra.mapping.PrimaryKeyClass
	public class PrimaryKeyClass implements Serializable {

		private static final long serialVersionUID = 1L;

		@PrimaryKeyColumn(name = "restaurant_code", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String restaurantCode;

		@PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
		private int id;

		public String getRestaurantCode() {
			return restaurantCode;
		}

		public void setRestaurantCode(String restaurantCode) {
			this.restaurantCode = restaurantCode;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			result = prime
					* result
					+ ((restaurantCode == null) ? 0 : restaurantCode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PrimaryKeyClass other = (PrimaryKeyClass) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			if (restaurantCode == null) {
				if (other.restaurantCode != null)
					return false;
			} else if (!restaurantCode.equals(other.restaurantCode))
				return false;
			return true;
		}

		private Menu getOuterType() {
			return Menu.this;
		}

	}
}
