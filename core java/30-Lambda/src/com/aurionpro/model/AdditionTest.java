package com.aurionpro.model;

public class AdditionTest {
	public static void main(String[] args) {
		 // IAddable obj1 = ()->System.out.println("Addition : "+(3+3));
		  // obj1.addition();

//		  IAddable obj1 = (number1, number2) -> number1 + number2;
//		  int sum = obj1.addition(10, 20);
//		  System.out.println(sum);
//		  
		  IAddable addObj= AdditionTest::add;//static reference
		  addObj.addition(10, 20);
		  
		  

	}
	public static void add(int number1,int number2) {
		int sum=number1+number2;
		System.out.println("Static variable sum"+" = "+sum);
	}
}
