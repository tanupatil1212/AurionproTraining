package com.aurionpro.model;

import java.util.LinkedList;
import java.util.ListIterator;

public class CustomLinkedList {
	 public static void main(String[] args) {
		  LinkedList<String> names=new LinkedList<String>();
		  System.out.println("Performing addition in linked list : ");
		  names.add("Tanuja");
		        names.addFirst("Sonal");
		        names.add("Vedant");
		        names.addLast("Sejal");
		        names.add("kunal");
		        names.add(2, "Harshal");
		        System.out.println(names);
		        
		       

		        System.out.println(names);
		        
		        System.out.println("Iterating :");
//		        for (int i = 0; i < names.size(); i++) { 
//		            System.out.print(names.get(i) + " "); 
//		        } 
//		        System.out.println(); 
//		        for (String x : names) {
//		         System.out.print(x + " "); 
//		        }    
		        ListIterator<String> iterator = names.listIterator();
		        while (iterator.hasNext()) {
		            System.out.print(iterator.next()+"\t");
		        }
		    
		        System.out.println("\nUpdating linked list : ");
		        names.set(4, "Preeti");
		        System.out.println(names);
		        
		        System.out.println("Performing deletion in linked list : ");
		        names.remove("Vedant");
		        names.remove(3);
		        names.removeFirst();
		        names.removeLast();
		 }

}
