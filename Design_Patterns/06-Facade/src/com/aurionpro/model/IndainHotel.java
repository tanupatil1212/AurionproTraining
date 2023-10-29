package com.aurionpro.model;

public class IndainHotel implements IHotel{

	@Override
	public IMenu getMenu() {
		return new IndianMenu();
	}
	
	
}