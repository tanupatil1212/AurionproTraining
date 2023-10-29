package com.aurionpro.test;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListCollection {

	public static void main(String[] args) {
		
		 List<Integer> numbers = new ArrayList<Integer>();
		 
		 numbers.add(10);
		 numbers.add(20);
		 numbers.add(30);
		 numbers.add(40);
		 
		 System.out.println(numbers.size());
		 System.out.println(numbers.contains(30));
		 
	//	 numbers.remove(new Integer(10));
		 numbers.remove(0);
		 System.out.println(numbers);
	//	 numbers.contains(10);


	}

}
