package com.aurionpro.test;

import com.aurionpro.model.PrimeNumber;

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println("Inside Main");
		PrimeNumber t1=new PrimeNumber();
		t1.setName("Printer 1");
		t1.start();
		PrimeNumber t2=new PrimeNumber();
		t2.setName("Printer 2");
		t2.start();
		System.out.println("End of Main");

	}

}
