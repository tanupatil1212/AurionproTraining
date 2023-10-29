package com.aurionpro.model;


public class Rectangle {

	private double height;
	private double width;
	private Color color;
	
	public Rectangle(double height,double width,Color color) {
		this.height=height;
		this.width=width;
		this.color=color;
	}
	
	public Rectangle() {
		this.height=0.0;
		this.width=0.0;
		this.color=Color.RED;
		
	}
	//set method for the height
	public void  setHeight( double height)
	
	{
		this.height = gettingValues(height);
	}
	
	
	//set method for the width
    public void setWidth(double width)
	{
		this.width =gettingValues(width);
	}
    
    
  //set method for the color
    public void setColor(Color color)
   	{
   		this.color =color;
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
    
//    public String gettingValues1(String color) {
//    	if (color.equalsIgnoreCase("blue")) {
//    		return "Blue";
//    	}
//    	else if(color.equalsIgnoreCase("green")) {
//    		return "Green";
//    				
//    	}
//    		return "Red";
//    }
//    
    
   
	
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	
	public double calculateArea()
	{
		return this.height*this.width;
		
	}
	
	
	
	}	
	


