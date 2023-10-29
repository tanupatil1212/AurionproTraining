package com.aurionpro.test;

import com.aurionpro.model.Color;
import com.aurionpro.model.Rectangle;
import com.aurionpro.test.Rectangle1;

public class RectangleTest {
	
	public static void main(String args[]) {
	
	Rectangle rectangle = new Rectangle();
	//Rectangle1 rectangle1 = new Rectangle1();
	
	rectangle.setHeight(-33);
	rectangle.setWidth(20);
	rectangle.setColor(Color.RED);
	//rectangle1.height= 10;
//	rectangle1.width= 3;
	
	
	//double area = rectangle.calculateArea();
	//double area1 = rectangle1.calculateArea1();
	System.out.println(rectangle.getHeight());
	System.out.println(rectangle.getWidth());
	System.out.println(rectangle.getColor());
	
	//System.out.println(area1);
	
	

	
	}

}
