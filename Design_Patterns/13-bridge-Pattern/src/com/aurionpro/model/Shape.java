package com.aurionpro.model;

public abstract class Shape {
	protected IColor color;

	public Shape(IColor color) {
		super();
		this.color = color;
	}
	
	abstract public void useColor();

}
