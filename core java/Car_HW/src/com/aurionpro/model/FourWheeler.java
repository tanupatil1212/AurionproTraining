package com.aurionpro.model;
import com.aurionpro.model.Vehicle;

public class FourWheeler extends Vehicle {
	private double mileage;

	public FourWheeler(String companyName,double mileage) {
		super(companyName);
		this.mileage=mileage;
		
	}
	
	public double getmiledge() {
		return mileage;
	}
	

}
