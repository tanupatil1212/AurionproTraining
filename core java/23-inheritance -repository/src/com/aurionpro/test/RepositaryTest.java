package com.aurionpro.test;

import com.aurionpro.model.IRepositary;
import com.aurionpro.model.ProductoRepositary;

public class RepositaryTest {

	public static void main(String[] args) {
		ProductoRepositary repositary = new  ProductoRepositary();
		repositary.create();
		repositary.read();
		repositary.update();
		repositary.delete();
		repositary.showGrettings();
		
		IRepositary.printWelcomeMessage();
		
	}

}
