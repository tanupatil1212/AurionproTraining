package com.Aurionpro.test;

public class SecondPassByvalue {

	public static void main(String[] args) {

		int[] numbers = {10,20,30,40,50};
		  
		  
		  for (int x : numbers) {
		   System.out.println("one"+x);
		  }
		  
		  incrementNumbersByOne(numbers);


		 }
		 
		 private static void incrementNumbersByOne(int[] numbers) {
		  for (int x: numbers) {
		   x=x+1;
		   
		   System.out.println("two"+x);
		  }
	}

}
