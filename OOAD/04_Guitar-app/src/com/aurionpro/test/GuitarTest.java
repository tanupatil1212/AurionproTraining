package com.aurionpro.test;

import java.util.List;


import com.aurionpro.model.Guitar;
import com.aurionpro.model.GuitarSpec;
import com.aurionpro.model.Inventory;
import com.aurionpro.model.GuitarType;
import com.aurionpro.model.Builder;
import com.aurionpro.model.Wood;


public class GuitarTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		GuitarSpec whatDipikaLikes = new GuitarSpec(Builder.FENDER, "stratocastor", GuitarType.ELECTRIC, Wood.ALDER, Wood.ALDER);
		List<Guitar> guitarList = inventory.searchGuitar(whatDipikaLikes);
		
		if (guitarList.size() != 0) {
			for (Guitar guitar: guitarList) {
				GuitarSpec spec = guitar.getSpec();
				System.out.println("Dear Customer, you might like this: ");
				System.out.println("Guitar Builder: "+ spec.getBuilder());
				System.out.println("Guitar Model: " + spec.getModel());
				System.out.println("Guitar Type: " + spec.getGuitarType());
				System.out.println("Guitar Top-Wood: " + spec.getTopWood());
				System.out.println("Guitar Back-Wood: " + spec.getBackWood());
				System.out.println("Hey! You can have this guitar for only Rs. " + guitar.getPrice());
				System.out.println("***********************************************************************");
			}
		} else {
			System.out.println("Sorry Tanuja! We have nothing for you :(");
		}
	}
	
	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("V95693", 1499.95, Builder.FENDER, "Stratocastor", GuitarType.ELECTRIC, Wood.ALDER, Wood.ALDER);
		inventory.addGuitar("V95121", 1549.95, Builder.FENDER, "Stratocastor", GuitarType.ELECTRIC,Wood.ALDER, Wood.ALDER);
		
	}


}
