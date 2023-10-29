package com.aurionpro.test;

import java.util.Scanner;

import com.aurionori.exception.InvalidAgeException;
import com.aurionpro.util.AgeUtil;

public class ValidateAgeTest {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter user Age");
		int age = sc.nextInt();
		
		try {
			AgeUtil.validateAge(age);
			
		}
		catch(InvalidAgeException e) {
			System.out.println(e);
		}
	}

}
