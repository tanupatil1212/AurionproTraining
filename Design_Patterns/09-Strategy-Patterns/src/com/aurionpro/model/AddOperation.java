package com.aurionpro.model;

public class AddOperation implements IOperation {

	@Override
	public void doOperation(int a, int b) {
		int result = a + b;
        System.out.println("Add Result: " + result);

	}

}
