package com.aurinpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.aurinpro.model.Account;
import com.aurinpro.model.Gender;

public class AccountTest {
	 public static void main(String[] args) {
	        List<Account> accounts = Arrays.asList(
	            new Account(1,"Tanuja",15000,Gender.FEMALE),
	            new Account(1,"Vedant",1500000,Gender.MALE),
	            new Account(1,"Sneha",345900,Gender.FEMALE),
	            new Account(1,"Deepak",123456,Gender.MALE),
	            new Account(1,"Namrata",456778,Gender.FEMALE),
	            new Account(1,"Suraj",6768766,Gender.MALE),
	            new Account(1,"Dviya",345566,Gender.FEMALE)
	         
	        );
	        
	        
	        List<Account> FemaleAccountList = accounts.stream()
	        		.filter((account)->account.getGender().equals(Gender.FEMALE))
	        		.collect(Collectors.toList());
	        		
	        		FemaleAccountList.forEach(System.out::println);
	        		
	        		System.out.println("*****************");
	        		
	        		
	        List<Account> MaleAccountList = accounts.stream()
	    	       .filter((account)->account.getGender().equals(Gender.MALE))
	    	        .collect(Collectors.toList());
	    	        		
	    	       MaleAccountList.forEach(System.out::println);
	    	        		
	    	      System.out.println("*****************");		

	        List<Account> sortedAccounts = accounts.stream()
	            .filter(account -> account.getBalance() > 100000)
	            .sorted((a1, a2) -> {
	                if (a1.getGender() != a2.getGender()) {
	                    return a1.getGender().compareTo(a2.getGender());
	                } else {
	                    return Double.compare(a2.getBalance(), a1.getBalance()); // Descending balance order
	                }
	            })
	            .collect(Collectors.toList());
	        
//	        System.out.println(accounts);
	        
	        System.out.println("*****************");
	        
	        sortedAccounts.forEach(System.out::println);
	        
	        
	        List<Double> balanceList = accounts.stream()
	        		.map((account)-> account.getBalance())
					.collect(Collectors.toList());
	        
	        System.out.println(balanceList);
	        System.out.println("************");

	        List<Account> sortedByBalanceList = accounts.stream()
	        		.sorted(Comparator.comparingDouble(Account::getBalance).reversed())
	        		.limit(3)
	        		.collect(Collectors.toList());
	        sortedByBalanceList.forEach(System.out::println);
	        
	   
	    }
	}
	


