package com.aurionpro.model;

public class ProductoRepositary implements IRepositary {
	@Override
	public void create() {
		System.out.println("Product created");
		
	}
	
	@Override
	public void read() {
System.out.println("Readings created");
		
	
		
	}
	@Override
	public void update() {
		System.out.println("updating prodcuts");
		
	}
	
	
	@Override
	public void delete() {
		System.out.println("deleting prodcuts");
		
	}
	
	public int printCategoriesCount() {
		return categories;
	}
	

	
}
