package com.aurionpro.test;

public class checkedException {

	public static void main(String[] args) {
		 System.out.println("Main Start");
		  function1();
		  System.out.println("Main End");
		 }
	

		 private static void function1() {
		  System.out.println("Function 1 Start");
		  try {
		   function2();
		  }catch(Exception e) {
		  // e.printStackTrace();
		   System.out.println("Handled in Function 1");
		  }
		  System.out.println("Function 1 End");
		 }
		 
		 
		 private static void function2() throws Exception {
		  System.out.println("Function 2 start");
		  function3();
		  System.out.println("Function 2 End");
		 }
		 
		 
		 private static void function3() throws Exception {
		  System.out.println("Function 3 Start");
		  function4();
		  System.out.println("Function 3 End");
		 }
		 
		 
		 private static void function4() throws Exception {
		  System.out.println("Function 4 start");
		  throw new Exception();
		 }

}
