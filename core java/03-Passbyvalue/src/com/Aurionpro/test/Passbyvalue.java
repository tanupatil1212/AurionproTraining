package com.Aurionpro.test;

public class Passbyvalue {

	public static void main(String[] args) {
		int number=2;
		System.out.println("number" + number);
		IncrementNumberByte(number);
		System.out.println(number);

	}
	private static void IncrementNumberByte(int x) {
		x += 10; // x=x+10x
		System.out.println("Sum"+ x);
	}
	
}
