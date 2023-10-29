package com.Aurionpro.test;

public class SecondLargest {
	
	  public static void main(String args[]) { 
		  
		  //command line input
	   int number[] = new int[args.length]; 
	   for(int i=0; i < args.length; i++)
	   {  
		   //String integer
	     number[i] = Integer.parseInt(args[i]);  
	     System.out.println(number[i]); 
	    } 
	  int largest = number[0];   // 0=12
	  int secondlargest =0; 
	  for(int i=1; i<number.length; i++) {                 // 12 18 14
	  if(largest < number[i])    //12<18         2nd// 18<14
	  { 
	   secondlargest = largest;       //SL=12
	   largest = number[i];           //L=18
	   } 
	  else if(secondlargest < number[i])       //12<14
	   { 
	   secondlargest = number[i];          //SL=14
	   } 
	 
	  System.out.println("The Largest Number is " + largest + " The Second Largest Number " + secondlargest);
	  }
	  
	 
	  }
}
	 


