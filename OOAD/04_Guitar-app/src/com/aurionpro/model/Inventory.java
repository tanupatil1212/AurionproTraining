package com.aurionpro.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitarsList;

	public Inventory() {
		super();
		this.guitarsList = new ArrayList<>();
	}
	
	public void addGuitar(String serialNum, double price, Builder builder, String model, GuitarType guitarType, Wood backWood, Wood topWood) {
		guitarsList.add(new Guitar(serialNum, price, new GuitarSpec(builder, model, guitarType, backWood, topWood)));
	}
	
	public Guitar getGuitar(String num) {
		for (Guitar x: guitarsList) {
			if (x.getSerialNum() == num) {
				return x;
			}
		}
		return null;
	}
	
	public List<Guitar> searchGuitar(GuitarSpec searchSpec) {
		List<Guitar> matchedGuitars = new ArrayList<>();
		
		for (Guitar guitar: guitarsList) {
//			GuitarSpec x = guitar.getSpec();
//			if (x.getBuilder().equals(y.getBuilder()) && 
//					x.getModel().equalsIgnoreCase(y.getModel()) && 
//					x.getGuitarType().equals(y.getGuitarType()) &&
//					x.getBackWood().equals(y.getBackWood()) &&
//					x.getTopWood().equals(y.getTopWood())) {
//				matchedGuitars.add(guitar);
//			}
			
			if (guitar.getSpec().matches(searchSpec)) {
				matchedGuitars.add(guitar);
			}
		}
		return matchedGuitars;
	}

}
