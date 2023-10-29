package com.aurionpro.test;

import com.aurionpro.model.BlueColor;
import com.aurionpro.model.Circle;
import com.aurionpro.model.RedColor;
import com.aurionpro.model.Shape;
import com.aurionpro.model.Square;

public class ShapeTest {
	
	public static void main(String args[]) {
		Shape circ =new Circle(new RedColor());
		circ.useColor();
		
		Shape squa= new Square(new BlueColor()); 
		squa.useColor();
	}

}
