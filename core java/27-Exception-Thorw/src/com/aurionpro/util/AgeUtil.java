package com.aurionpro.util;

import com.aurionori.exception.InvalidAgeException;

public class AgeUtil {
	public static void validateAge(int age) {
		if(age>=18) {
			System.out.println("Eligible for voting..");
			
		}
		else {
			throw new InvalidAgeException("Invalid age");
		}
	}

}
