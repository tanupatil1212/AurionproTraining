package com.aurionpro.model;

public class CarFactory {
	
	
	public ICars getCarInstance( CarType car){
		if(car.equals(CarType.Maruti))
		{
			return new Maruti();
		}
		
		if(car.equals(CarType.Tata))
		{
			return new Tata();
		}
		
		if(car.equals(CarType.Mahindra))
		{
			return new Mahindra();
		}
		return null;
	}
	
	

}
