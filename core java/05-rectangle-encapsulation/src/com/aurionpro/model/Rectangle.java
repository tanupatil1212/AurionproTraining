package com.aurionpro.model;

public class Rectangle {

	private double height;
	private double width;
	
	public void   setHeight( double height)
	
	{
		this.height = gettingValues(height);
	}
	
    public void setWidth(double width)
	{
		this.width =gettingValues(width);
	}
    
    public double gettingValues(double value) {
    	if(value>100)
    	{
    		value= 100;
    	}
    	else if(value<1)
    	{
    		value = 1;
    		
    	}
    	return value;
    		
    }
	
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	
	public double calculateArea()
	{
		return this.height*this.width;
		
	}
		
	
}

