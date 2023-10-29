package com.aurionpro.test;


import com.aurionpro.model.DiwaliInterest;
import com.aurionpro.model.FestivalType;
import com.aurionpro.model.FixedDeposit;
import com.aurionpro.model.HoliInterest;
import com.aurionpro.model.IFestivalInterest;

public class FDTest {

	public static void main(String[] args) {
		
		
		FixedDeposit fd1 = new FixedDeposit(101,"Tanuja",1000,2,FestivalType.DIWALI,new DiwaliInterest()); 
		System.out.println(fd1);
//		fd1.getInterestRate();
//		fd1.calculateSimpleInterest();
		System.out.println("*******************");
		 double interestRate = fd1.getInterestRate();
	        System.out.println("Interest Rate: " + interestRate);
	        System.out.println("*******************");
	        // Calculate and print the simple interest
	        double simpleInterest = fd1.calculateSimpleInterest();
	        System.out.println("Simple Interest: " + simpleInterest);
		

	}

}
