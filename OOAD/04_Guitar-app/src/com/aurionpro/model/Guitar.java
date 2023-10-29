package com.aurionpro.model;

public class Guitar {
	private String serialNum;
	private double price;
	private GuitarSpec spec;
	
	public Guitar(String serialNum, double price, GuitarSpec spec) {
		super();
		this.serialNum = serialNum;
		this.price = price;
		this.spec = spec;
//		this.spec = new GuitarSpec(builder, model, guitarType, backWood, topWood);
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public GuitarSpec getSpec() {
		return spec;
	}

	public void setSpec(GuitarSpec spec) {
		this.spec = spec;
	}
	
	

}
