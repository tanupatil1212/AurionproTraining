package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.CustomerAsending;

public class CustomerAsendingTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerAsending[] customer = {
				new CustomerAsending(1, "Tanuja", "tanuja@gmailcom", 123),
				new CustomerAsending(2, "Sneha", "sneha@gmail.com", 123),
				new CustomerAsending(3, "Divya", "divya@gmail.com", 123),
				new CustomerAsending(4, "Namrata", "namrata@gmail.com", 123),
				new CustomerAsending(5, "sujata", "sujata@gmail.com", 123),
				new CustomerAsending(6, "Dipti", "dipti@gmail.com", 123),
				new CustomerAsending(7, "Pooja", "pooja@gmail.com", 123),
				new CustomerAsending(8, "aditi", "aditi@gmail.com", 123),
				new CustomerAsending(9, "Mansi", "mamsi@gmail.com", 123),
				new CustomerAsending(10,"Reshma", "reshma@gmail.com", 123)

		};

		Scanner userin = new Scanner(System.in);

		
		sortArray(customer);
		
	}

	private static void sortArray(CustomerAsending[] customer) {
		CustomerAsending obj = customer[0];
		CustomerAsending temp = null;
		 for (int i = 0; i < customer.length; i++) {
			obj = customer[i];
			for (int j = 0; j < customer.length; j++) {
				
			
				if(obj.getName().compareToIgnoreCase(customer[j].getName())<0) {
					temp = customer[i];
					customer[i]=customer[j];
					customer[j]=temp;
				
			}
			}
		}
		 for (int i = 0; i < customer.length; i++) {
			 System.out.println(customer[i]);
		}
		 //return obj;
		
	}

	private static CustomerAsending validateEmail(CustomerAsending[] customer) {
		CustomerAsending obj = null;
		for (int i = 0; i < customer.length; i++) {
			obj = customer[i];
			int atTheRate = obj.getEmail().indexOf("@");
			int com = obj.getEmail().indexOf(".com");
			System.out.println(customer[i]);
			
			if(atTheRate !=-1 && com!=-1) {
				System.out.println("Valid Email ID");
			}
			else {
				System.out.println("Invalid Email ID!");
			}
				
		}
		return obj;
		
	}

}
