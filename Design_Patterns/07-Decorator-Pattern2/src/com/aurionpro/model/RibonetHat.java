package com.aurionpro.model;

public class RibonetHat extends HotDecorator {

	public RibonetHat(IHat hat) {
		super(hat);
		
	}
	
	public String getName() {
		return "RibonetHAt" +super.getName();
	}
	
	public double getPrice() {
		return 100 +super.getPrice();
	}

}
