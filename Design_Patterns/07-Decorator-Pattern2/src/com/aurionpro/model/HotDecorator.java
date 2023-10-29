package com.aurionpro.model;

public abstract class HotDecorator implements IHat {
	
	private IHat hat;

	public HotDecorator(IHat hat) {
		super();
		this.hat = hat;
	}
	
	@Override
	public String getName() {
		
		return hat.getName();
	}

	@Override
	public double getPrice() {
		
		return hat.getPrice();
	}

	@Override
	public String getDescription() {
		
		return hat.getDescription();
	}

}
