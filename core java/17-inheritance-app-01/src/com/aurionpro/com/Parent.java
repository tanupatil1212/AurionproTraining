package com.aurionpro.com;

public class Parent {
	public Parent()
	{
		System.out.println("Inside Parent Constructor");
		this.value=0;
	}
	
	private int value;

	public Parent(int value) {
		
		System.out.println("Inside Parent Constructor");
		this.value=value;
	}
	

}
