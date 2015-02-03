package com.agamin.model;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private Double customerid;
	private String city;
	private String country;
	private String first_name;
	private String last_name;
	private String email;
	private Double mobile;
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
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Double getMobile() {
		return mobile;
	}
	public void setMobile(Double mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
