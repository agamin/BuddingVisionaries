package com.agamin.model;

import java.io.Serializable;

public class Customer implements Serializable{

	//Serialize
	private static final long serialVersionUID = 1L;
	private Double customerid;
	private String city;
	private String country;
	private String name;
	private int pin;
	private String state;
	private String street;

	public Double getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Double customerid) {
		this.customerid = customerid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

}
