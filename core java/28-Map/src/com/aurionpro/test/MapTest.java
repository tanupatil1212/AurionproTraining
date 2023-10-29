package com.aurionpro.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer,String> nameMap=new HashMap<>();
		
		nameMap.put(1, "Tanuja");
		nameMap.put(2, "Sneha");
		nameMap.put(3, "Namrata");
		
		Set<Entry<Integer,String>>entrySet=nameMap.entrySet();
		for(Entry x:entrySet) {
			System.out.println(x.getKey()+" "+x.getValue());
		}
		nameMap.forEach((key,value)->{
			System.out.println(key+" "+value);
		});
		
		

	}

}
