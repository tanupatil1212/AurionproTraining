package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		Stream<Integer> intStream=Stream.of(10,20,30,40);
		String[] names = {"Tejas","Sonu","Monu","rajanandin"};
		List<String> filteredNames = new ArrayList<String>();
		for (String name : names) {
			if(name.length()==3 || name.length()==4)
				filteredNames.add(name);
		}
		for(String name : filteredNames) {
			System.out.println(name);
		}
		Arrays.stream(names)
	    .filter(name -> name.length() == 3 || name.length() == 4)
	    .forEach(System.out::println);

//		List<String> collectNames = Arrays.stream(names)
//				.filter(name ->(name.length()==3 || name.length()==4))
//				.collect(Collectors.toList());
//		collectNames.stream().forEach((name)->System.out.println(name));		

	}

}
