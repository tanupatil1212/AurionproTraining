package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;

public class ArrayListMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 25, 35, 45);

        // Find min and max in Integer ArrayList
        int min = numbers.stream()
                         .min(Integer::compare)
                         .orElse(0);  // Default value if list is empty
        int max = numbers.stream()
                         .max(Integer::compare)
                         .orElse(0);  // Default value if list is empty

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
	}

}
