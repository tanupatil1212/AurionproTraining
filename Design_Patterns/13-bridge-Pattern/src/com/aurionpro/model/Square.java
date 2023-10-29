package com.aurionpro.model;

public class Square extends Shape {

	public Square(IColor color) {
		super(color);
	}

	@Override
	public void useColor() {

		System.out.println("Square with color");
		color.useColor();
	}

}
