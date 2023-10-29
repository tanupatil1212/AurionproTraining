package com.aurionpro.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class occurenceTest {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(10,20,30,40,50,30,20);
		Map<Integer,Integer>countMap=new HashMap<Integer,Integer>();
		//frequency of the number
          for(Integer x : numberList) {
        	  if(!countMap.containsKey(x)) {
        		  countMap.put(x,1);
        	  }
        	  else {
        		  countMap.put(x,countMap.get(x)+1);
        	  }
        	  
          }
          countMap.forEach((key,value)->{
        	  System.out.println(key+" "+value);
          });
	}
////	numberList.forEach(x)->{
////		System.out.println(x);
	}



