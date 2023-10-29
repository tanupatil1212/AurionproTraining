package com.aurionpro.model;

public class Circle implements IShape {

	 private String color;

	    public Circle(String color) {
	        this.color = color;
	    }

	    public void draw() {
	        System.out.println("Drawing a " + color + " circle");
	        System.out.println("Hash Code: " + this.hashCode());
	        System.out.println("-------------");
	    }

}
