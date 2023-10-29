package com.aurionpro.model;

import java.time.LocalDate;

public class Bike extends Vehicle implements IMovable  {

	public Bike(String model, LocalDate dom) {
		super(model, dom);
		
	}

	@Override
	public void Move() {
		System.out.println("Bike is Moving");
		
	}

	@Override
	public void showTopSpeed() {
		System.out.println("Bike top speed is 15kmph");
	}
	
	

}
