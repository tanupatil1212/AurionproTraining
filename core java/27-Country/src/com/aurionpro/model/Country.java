package com.aurionpro.model;

public class Country {
	String countryName;
	int id;
	
	public Country(String countryName, int id) {
		super();
		this.countryName = countryName;
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", id=" + id + "]";
	}



	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
