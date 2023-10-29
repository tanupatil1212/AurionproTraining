package com.aurionpro.model;
import com.aurionpro.model.Vehicle;
import com.aurionpro.model.FourWheeler;


public class Car extends FourWheeler {
	private double price;

	public Car(String companyName,double mileage,double price) {
		super(companyName,mileage);
		this.price=price;
		
	}
	public double getPrice() {
		return price;
	}

	
}
