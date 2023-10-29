package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.model.Account;

public class AccountOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Account> accounts = new ArrayList<>();
	        accounts.add(new Account(1, "Alice", 5000));
	        accounts.add(new Account(2, "Bob", 8000));
	        accounts.add(new Account(3, "Charlie", 3000));
	        accounts.add(new Account(4, "David", 7000));
	        accounts.add(new Account(5, "Eva", 6000));

	        // a. Show Account details of account with minimum Balance
	        System.out.println("a. Account details with minimum balance:");
	        Account minBalanceAccount = accounts.stream()
	                .min(Comparator.comparing(Account::getBalance))
	                .orElse(null);
	        System.out.println(minBalanceAccount.getId() + ", " + minBalanceAccount.getName() + ", " + minBalanceAccount.getBalance());
	        System.out.println("*****************************************************************");

	        // b. Show Account details of account with maximum Balance
	        System.out.println("b. Account details with maximum balance:");
	        Account maxBalanceAccount = accounts.stream()
	                .max(Comparator.comparing(Account::getBalance))
	                .orElse(null);
	        System.out.println(maxBalanceAccount.getId() + ", " + maxBalanceAccount.getName() + ", " + maxBalanceAccount.getBalance());
	        System.out.println("*****************************************************************");

	        // c. Show names greater than 6 characters
	        System.out.println("c. Names greater than 6 characters:");
	        List<String> longNames = accounts.stream()
	                .map(Account::getName)
	                .filter(name -> name.length() > 6)
	                .collect(Collectors.toList());
	        longNames.forEach(System.out::println);
	        System.out.println("*****************************************************************");

	        // d. Find total balance of all accounts
	        System.out.println("d. Total balance of all accounts:");
	        double totalBalance = accounts.stream()
	                .mapToDouble(Account::getBalance)
	                .sum();
	        System.out.println(totalBalance);
	    }
	}


