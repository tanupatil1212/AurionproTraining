package com.Aurionpro.test;

public class FactorialCommandline {

	public static void main(String[] args) {
		
			   int i,s=1;
			   //Taking input from the command Line
			   int n=Integer.parseInt(args[0]);
			   for(i=1;i<=n;i++)
			   {
			   s=s*i;
			   }
			   System.out.println("Factorial of number is:"+s);
		

	}

}
