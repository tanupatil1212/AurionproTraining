package com.aurionpro.model;

import java.time.LocalDate;

public class Car extends Vehicle implements IMovable {

	public Car(String model, LocalDate dom) {
		super(model, dom);

	}

	@Override
	public void Move() {
		System.out.println("Car is Moving");

	}

	@Override
	public void showTopSpeed() {
		System.out.println("100 KMPH");
	}

}
