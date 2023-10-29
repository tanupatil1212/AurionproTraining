package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;

import com.aurionpro.model.PrintValue;
import com.aurionpro.model.Rectangle;

public class PrintTest {

	public static void main(String[] args) {
		PrintValue<Integer> printObj1 = new PrintValue<Integer>(10);
		printObj1.print();

		PrintValue<Double> printObj2 = new PrintValue<Double>(10.5);
		printObj2.print();

		PrintValue<String> printObj3 = new PrintValue<String>("Tanuja");
		printObj3.print();

//		PrintValue<Rectangle> printObj4 = new PrintValue<Rectangle>(new Rectangle(10, 20));
//		printObj4.print();
		
//		PrintValue<Rectangle> obj = new PrintValue<Rectangle>(new Rectangle(10, 20));
//		obj.print();
		
//		printValues(10,"Tanuja");
//		printValues(10.5,true);
//		printValues("tanuja",2.5f);
		
		List<Integer> inList = Arrays.asList(10,20,30,40);
		List intList;
		printList(inList);
		
		List<Double> doubleList = Arrays.asList(10.4,20.4,30.4,40.4);
		printList(doubleList);
		
		
	}
//	private static <T,S> void printValues(T value1,S value2) {
//		System.out.println(value1+" "+value2);
//		System.out.println(value2);
//		System.out.println(value3);
	
	private static <T>void printList(List<T> list){
		for(T x:list) {
			System.out.println(x);
		}
	}

}
