package com.aurionpro.test;

import com.aurionpro.model.Border;
import com.aurionpro.model.Circle;
import com.aurionpro.model.Color;

public class CircleTest {
	public static void main(String args[]) {
		
	
	
	Circle circle = new Circle();
	
	circle.setRadius(4);
	circle.setBorder(Border.DASHED);
	circle.setColor(Color.RED);
	
	
	System.out.println("Radius of the circle" + " = "+circle.getRadius());
	System.out.println("Radius of the Border" + " = "+circle.getBorder());
	System.out.println("Radius of the colore" + " = "+circle.getColor());
	
	System.out.println("Area of Circle" + " = "+circle.calculateArea());
	System.out.println("Perimeter" + " = "+circle.perimeter());
	
	
	
	
	}

}
