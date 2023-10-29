
package com.Aurionpro.test;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Enter a Number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int fact =1,i =1;
		while( i<=num)
		  {
		     fact=fact*i;
			 i++;
		  }	 

		 System.out.println("Factorial of the no"  +" " + fact );
		

	}

}
