package com.aurionpro.test;

import com.aurionpro.model.Rectangle;

import java.util.Scanner;
import com.aurionpro.test.Rectangle1;
import com.aurionpro.model.Color;

public class RectangleTest {
	
	public static void main(String args[]) {
		
			Rectangle[] rectangles = new Rectangle[2];
			for(int i = 0; i< rectangles.length;i++) {
				rectangles[i] = new Rectangle();
				
				gettValues(rectangles[i]);
				printRecatnagleValues(rectangles[i]);
			}
			
			for(int i =0;i<rectangles.length;i++) {
				gettValues(rectangles[i]);
			}
		}
	
	//Rectangle rectangle = new Rectangle();
	//Rectangle rectangle1 = new Rectangle();
	
	//second rectangle
	
	
//	rectangle.setColour("green");
	//rectangle1.height= 10;
//	rectangle1.width= 3;
	
	
	//double area = rectangle.calculateArea();
	//double area1 = rectangle1.calculateArea1();
	
//	gettValues(rectangle);
//	printRecatnagleValues(rectangle);
//	System.out.println("***************************");
//	gettValues(rectangle1);
//	printRecatnagleValues(rectangle1);
	
	
	
	
	public static void printRecatnagleValues(Rectangle rectangle) {
		System.out.println("Height of the Rectangle"+ " : " +rectangle.getHeight());
		System.out.println("Width of the Rectangle"+ " : " +rectangle.getWidth());
		System.out.println("Color of the Rectangle"+ " : " +rectangle.getColor());
		System.out.println("Area of the Circle"+ " : " +rectangle.calculateArea());
	}
	
	public static void gettValues(Rectangle rectangle) {
		System.out.println("Enter the Height");
		Scanner sc = new Scanner(System.in);
		double height = sc.nextDouble();
		
		System.out.println("Enter the Width");
		
		double width = sc.nextDouble();
		
		System.out.println("Enter the Color");
		try {
		rectangle.setColor(Color.valueOf(sc.next().toUpperCase()));
		}
		catch (IllegalArgumentException e) {
			rectangle.setColor(Color.RED);
		}
		
		rectangle.setHeight(height);
		rectangle.setWidth(width);
		
	}

	
}
