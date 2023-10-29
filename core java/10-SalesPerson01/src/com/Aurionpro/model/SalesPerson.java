package com.Aurionpro.model;

import com.Aurionpro.model.City;

public class SalesPerson {
	
	private int id;
	private String name;
	private City city;
	private  int experience;
	private  double salesAmount;
	
	
	
	
	public SalesPerson(int id, String name, City city, int experience,double salesAmount) {
		super();
		this.id = id;
		this.name = name;
		this.city= city;
		this.experience =experience ;
		this.salesAmount =salesAmount ;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public City getCity() {
		return city;
	}




	public void setCity(City city) {
		this.city = city;
	}




	public int getExperience() {
		return experience;
	}




	public void setExperience(int experience) {
		this.experience = experience;
	}




	public double getSalesAmount() {
		return salesAmount;
	}




	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}




	@Override
	public String toString() {
		return "SalesPerson [id=" + id + ", name=" + name + ", city=" + city + ", experience=" + experience
				+ ", salesAmount=" + salesAmount + "]";
	}

 
	
	


	
	
	
  

}
