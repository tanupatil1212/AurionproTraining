package com.Aurionpro.test;

public class SumOfnum {

	public static void main(String[] args) {
		int sum=1;
		for (int i =0;i<args.length;i++) {
			sum=sum+Integer.parseInt(args[i]);
			
		}
		System.out.println("sum"+" "+ sum );
	}

}
