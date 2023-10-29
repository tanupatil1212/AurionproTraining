package com.aurionpro.model;

public class Circle extends Shape {
	public Circle(IColor color) {
		super(color);
	}

	@Override
	public void useColor() {

		System.out.println("Circle with color");
		color.useColor();
	}

}
