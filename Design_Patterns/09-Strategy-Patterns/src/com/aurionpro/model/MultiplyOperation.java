package com.aurionpro.model;

public class MultiplyOperation implements IOperation {

	@Override
	public void doOperation(int a, int b) {
		int result = a * b;
        System.out.println("Multiply Result: " + result);

	}

}
