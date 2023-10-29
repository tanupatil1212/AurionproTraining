package com.aurionpro.model;

public class OperationStrategyTest {

	public static void main(String[] args) {
		int a = 5; // Replace with your desired values
        int b = 3; // Replace with your desired values

        OperationStrategy op = new OperationStrategy(new AddOperation());
        op.doOperation(a, b);

        op.setOperation(new MultiplyOperation());
        op.doOperation(a, b);

	}

}
