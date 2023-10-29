package com.aurionpro.model;

public class PremiumHat implements IHat {

	@Override
	public String getName() {
		
		return "Primium";
	}

	@Override
	public double getPrice() {
		
		return 150;
	}

	@Override
	public String getDescription() {
		
		return "PremiumHat is here";
	}

}
