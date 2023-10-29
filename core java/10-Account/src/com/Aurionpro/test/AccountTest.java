package com.Aurionpro.test;

import com.Aurionpro.model.AccountType;

import com.Aurionpro.model.Account;

import java.util.Scanner;

public class AccountTest {
	public static void main(String args[]) {

		Account[] accounts = { new Account(1, "Dinesh", 4533, AccountType.SAVINGS),
				new Account(2, "sonu", 5663, AccountType.CURRENT),
				new Account(3, "monu", 7664, AccountType.SAVINGS),
				new Account(4, "radhika", 1224, AccountType.CURRENT),
				new Account(5, "sunkashi", 3456, AccountType.SAVINGS),
				new Account(6, "Tejas", 4789, AccountType.CURRENT), 
				new Account(7, "Roshan", 5767, AccountType.SAVINGS),
				new Account(8, "Harshal", 8978, AccountType.CURRENT),
				new Account(9, "sejal", 5453, AccountType.SAVINGS),
				new Account(10, "surekha", 6754, AccountType.CURRENT) };

		Account highestBalanceAccount = findHighestBalanceAccount(accounts);
		System.out.println("Account with Highest Balance : " + highestBalanceAccount);

		Account highestCurrentBalanceAccount = findHighestBalanceAccountInAccountType(accounts, AccountType.CURRENT);
		System.out.println("Highest Balance in Current Account : " + highestCurrentBalanceAccount);

		Account highestSavingsBalanceAccount = findHighestBalanceAccountInAccountType(accounts, AccountType.SAVINGS);
		System.out.println("Highest Balance in Savings Account : " + highestSavingsBalanceAccount);

		double sumofAllAccounts = findSumBalanceAccount(accounts);
		System.out.println("Account with Highest Balance : " + sumofAllAccounts);

		double sumofAccountsBalance = findSumBalanceAccountType(accounts, AccountType.SAVINGS);
		System.out.println("Account with Savings Highest Balance : " + sumofAccountsBalance);

		double sumofAccountsBalance1 = findSumBalanceAccountType(accounts, AccountType.CURRENT);
		System.out.println("Account with Current Highest Balance : " + sumofAccountsBalance1);

		sortAccountsArrayBySalary(accounts);
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Sorted Account" + accounts[i]);
			
		}

	}
	//Highest Balance
	private static Account findHighestBalanceAccount(Account[] accounts) {
		Account maxAccount = accounts[0];

		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getBalance() > maxAccount.getBalance()) {
				maxAccount = accounts[i];
			}
		}
		return maxAccount;
	}
	
	//Account holder highest balance in SAVING AND CURRENT
	private static Account findHighestBalanceAccountInAccountType(Account[] accounts, AccountType type) {
		Account maxAccount = null;

		for (int i = 0; i < accounts.length; i++) {
			if (maxAccount == null && accounts[i].getAccountType().equals(type)) {
				maxAccount = accounts[i];
			}

			if (maxAccount != null) {
				if (accounts[i].getBalance() > maxAccount.getBalance() && accounts[i].getAccountType().equals(type)) {
					maxAccount = accounts[i];
				}
			}
		}
		return maxAccount;
	}

	
//findSumBalanceAccount
	private static double findSumBalanceAccount(Account[] accounts) {
		
		double sum = 0;
		for (int i = 0; i < accounts.length; i++) {
			sum += accounts[i].getBalance();
		}
		return sum;
	}
	//findSumBalanceAccountType
	private static double findSumBalanceAccountType(Account[] accounts, AccountType type) {
		
		double sum = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getAccountType().equals(type)) {
				sum += accounts[i].getBalance();
			}
		}
		return sum;
	}
	
	
	private static void sortAccountsArrayBySalary(Account[] accounts) {
		Account temp = null;
		for (int i = 0; i < accounts.length; i++) {
			for (int j = 0; j < accounts.length - 1; j++) {
				if (accounts[i].getBalance() < accounts[j].getBalance()) {
					temp = accounts[i];
					accounts[i] = accounts[j];
					accounts[j] = temp;
				}
			}
		}
	}

	


	

	
}
