package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;

public class NameOperations {
	public static void main(String[] args) {
        String[] names = {"Jay", "Nimesh", "Mark", "Mahesh", "Ramesh"};

        // a. Print names of first 3 students sorted in ascending order
        System.out.println("a. Names of first 3 students sorted in ascending order:");
        Arrays.stream(names)
              .sorted()
              .limit(3)
              .forEach(System.out::println);
        System.out.println("*****************************************************************");

        // b. Print names of first 3 students sorted in ascending order if their names contain 'a'
        System.out.println("b. Names of first 3 students containing 'a', sorted in ascending order:");
        Arrays.stream(names)
              .filter(name -> name.contains("a"))
              .sorted()
              .limit(3)
              .forEach(System.out::println);
        System.out.println("*****************************************************************");

        // c. Print names of students sorted in descending order
        System.out.println("c. Names of students sorted in descending order:");
        Arrays.stream(names)
              .sorted(Comparator.reverseOrder())
              .forEach(System.out::println);
        System.out.println("*****************************************************************");

        // d. Print first 3 characters of names of students
        System.out.println("d. First 3 characters of names of students:");
        Arrays.stream(names)
              .map(name -> name.substring(0, Math.min(name.length(), 3)))
              .forEach(System.out::println);
        System.out.println("*****************************************************************");

        // e. Print the names of students that contain less than or equal to 4 characters
        System.out.println("e. Names of students with length <= 4 characters:");
        Arrays.stream(names)
              .filter(name -> name.length() <= 4)
              .forEach(System.out::println);
    }

}
