package com.aurionpro.model;

import java.time.LocalDate;

public abstract class Vehicle {
	private String model;
	private LocalDate dom;

	public Vehicle(String model, LocalDate dom) {
		super();
		this.model = model;
		this.dom = dom;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getDom() {
		return dom;
	}

	public void setDom(LocalDate dom) {
		this.dom = dom;
	}
	
	public abstract void showTopSpeed();

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", dom=" + dom + "]";
	}

}
