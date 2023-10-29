package com.aurionpro.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Occurence1 {
	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(10,20,30,40,50,30,20);
		Map<Integer,Integer>numberMap=new HashMap<Integer,Integer>();


		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the Name :");
		  String name = sc.next();

		  Map<Integer, String> nameMap = new HashMap<>();

		  nameMap.put(1, "Ram");
		  nameMap.put(2, "Sita");
		  nameMap.put(3, "Laxman");
		  nameMap.put(4, "Radha");
		  nameMap.put(5, "Dinesh");
		  nameMap.put(6, "Ganesh");

		  Set<Entry<Integer, String>> entrySet = nameMap.entrySet();

		  boolean isExist = false;
		  for (Entry x : entrySet) {
		   if (name.equals(x.getValue())) {
		    nameMap.remove(x.getKey());
		    isExist = true;
		    break;
		   }
		  }

		  if (!isExist) {
		   System.out.println("Not FOund");
		   nameMap.forEach((key, value) -> {
		    System.out.println(key + " " + value);

		   });

		  } else {
		   nameMap.forEach((key, value) -> {
		    System.out.println(key + " " + value);

		   });

		  }

		 }
		}


