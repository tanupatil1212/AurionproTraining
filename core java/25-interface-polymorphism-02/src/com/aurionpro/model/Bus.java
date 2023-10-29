package com.aurionpro.model;

import java.time.LocalDate;

public class Bus extends Vehicle implements IMovable {

	public Bus(String model, LocalDate dom) {
		super(model, dom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		System.out.println("Bus is Moving");
		
		
	}

	@Override
	public void showTopSpeed() {
		System.out.println("bus top speed is");
		
	}

}
