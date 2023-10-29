package com.aurionpro.model;

import java.util.*;

public class BeerExpert 
{
	public List getBrands(String color) {
		List brands= new ArrayList<>();
		if(color.equals("amber")) 
		{
			brands.add("Jack Amber");
			brands.add("Red Moose");
			brands.add("Zlacy Rosamber");
		}else 
		{
			brands.add("Ale Aqil");
			brands.add("Grout Strot");
		}
		return brands;
	}
	

}
