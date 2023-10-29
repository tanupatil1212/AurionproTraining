package com.aurionpro.model;

public class Rectangle {

	private double height;
	private double width;
	private String colour;
	
	//set method for the height
	public void   setHeight( double height)
	
	{
		this.height = gettingValues(height);
	}
	
	
	//set method for the width
    public void setWidth(double width)
	{
		this.width =gettingValues(width);
	}
    
    
  //set method for the colour
    public void setColour(String colour)
   	{
   		this.colour =gettingValues1(colour);
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
    
    public String gettingValues1(String colour) {
    	if (colour.equalsIgnoreCase("blue")) {
    		return "Blue";
    	}
    	else if(colour.equalsIgnoreCase("green")) {
    		return "Green";
    				
    	}
    		return "Red";
    }
    
    
   
	
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	
	public String getColour() {
		return colour;
	}
	
	
	public double calculateArea()
	{
		return this.height*this.width;
		
	}
		
	
}

