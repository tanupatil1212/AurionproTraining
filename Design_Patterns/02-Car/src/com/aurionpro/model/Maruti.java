package com.aurionpro.model;

public class Maruti implements ICars {

	@Override
	public void start() {
		System.out.println("Car is Strating");

	}

	@Override
	public void stop() {
		System.out.println("Car is Stop");
	}

}
