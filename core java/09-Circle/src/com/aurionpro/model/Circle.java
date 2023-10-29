package com.aurionpro.model;

public class Circle {
	
	private double radius;
	private Color color;
	private Border border;
	
	//set method for the RADIUS
		public void   setRadius( double radius)
		
		{
			this.radius = radius;
		}
		
		
		//set method for the BORDER
	    public void setBorder(Border border)
		{
			this.border =border;
		}
	    
	    
	  //set method for the color
	    public void setColor(Color color)
	   	{
	   		this.color =color;
	   	}
	
	    
	    //get method
	    
	    public double getRadius() {
			return radius;
		}
		public Border getBorder() {
			return border;
		}
		
		public Color getColor() {
			return color;
		}
		
		public double calculateArea()
		{
			return 3.14*(radius*radius);
			
		}
		
		public double perimeter()
		{
			return 2*Math.PI*radius;
			
		}
		
		
			
	

}
