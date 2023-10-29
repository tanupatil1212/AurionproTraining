package com.aurionpro.model;

public class GuitarSpec<Wood, Builder> {
	private Builder builder;
	private String model;
	private GuitarType guitarType;
	private Wood backWood;
	private Wood topWood;
	
	
	public GuitarSpec(Builder builder, String model, GuitarType guitarType, Wood backWood, Wood topWood) {
		super();
		this.builder = builder;
		this.model = model;
		this.guitarType = guitarType;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	
	public Builder getBuilder() {
		return builder;
	}
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public GuitarType getGuitarType() {
		return guitarType;
	}
	
	public void setGuitarType(GuitarType guitarType) {
		this.guitarType = guitarType;
	}
	
	public Wood getBackWood() {
		return backWood;
	}
	
	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}
	
	public Wood getTopWood() {
		return topWood;
	}
	
	public void setTopWood(Wood topWood) {
		this.topWood = topWood;
	}

	public boolean matches(GuitarSpec searchSpec) {
		// TODO Auto-generated method stub
		if (builder.equals(searchSpec.getBuilder()) && 
				model.equalsIgnoreCase(searchSpec.getModel()) && 
				guitarType.equals(searchSpec.getGuitarType()) &&
				backWood.equals(searchSpec.getBackWood()) &&
				topWood.equals(searchSpec.getTopWood())) {
			return true;
		}
		return false;
	}
	
	


}
