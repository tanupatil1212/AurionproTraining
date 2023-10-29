package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;

import com.aurionpro.model.NameStream;

public class nameStream {
    static List<String> nameList;  // Declare nameList at the class level

    public static void main(String[] args) {
        String[] names = {"Jayesh", "Nimesh", "Mahesh", "Ramesh"};

        // a. Using names.stream().forEach
        System.out.println("Using names.stream().forEach:");
        Arrays.stream(names).forEach(System.out::println);
        System.out.println("*****************************************************************");

        // b. Using Arrays.asList(names).forEach
        System.out.println("Using Arrays.asList(names).forEach:");
        nameList = Arrays.asList(names);  // Assign the list to the class-level variable
        nameList.forEach(System.out::println);
        System.out.println("*****************************************************************");

        // c. Using static reference method
        System.out.println("Using static reference method:");
        nameList.forEach(NameStream::printName);
    }
}
