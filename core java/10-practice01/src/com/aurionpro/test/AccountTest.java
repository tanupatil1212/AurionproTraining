package com.aurionpro.test;
import com.aurionpro.model.Account;
import com.aurionpro.model.accountType;

import java.util.Arrays;
import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] accounts= new Account[4];
		int count=0;
		double maxbal=0;
		for(int i=0;i<accounts.length;i++) {
			accounts[i]=new Account();
			SetAccounts(accounts[i]);
			count++;			
		}
		System.out.println(	MaxBalance(accounts));
		
		System.out.println(	"Max Bal for Savings acc is "+maxBalanceInAccountType(accounts,accountType.SAVING));
		System.out.println(	"Max Bal for Savings acc is "+maxBalanceInAccountType(accounts,accountType.CURRENT));
		System.out.println("Total Bal is "+totalBalance(accounts));
		System.out.println("Total Bal of Saving Accs "+ totalBalanceOfSavings(accounts, accountType.SAVING));
		System.out.println("Total Bal of Current Accs "+ totalBalanceOfSavings(accounts, accountType.CURRENT));
		sortAccounts(accounts);
		
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Sorted Account : \n"+accounts[i]);
		}
	}
	
	private static void SetAccounts(Account account) {
		Scanner userin = new Scanner(System.in);
		System.out.println("Enter ID, Name and Balance");
		account.setId(userin.nextInt());
		account.setName(userin.next());
		account.setBalance(userin.nextDouble());
		System.out.println("Enter Account Type SAVING OR CURRENT");
		try {
			account.setAccountType(accountType.valueOf(userin.next().toUpperCase()));
		}
		catch(Exception e) {
			account.setAccountType(accountType.SAVING);
		}
		
		System.out.println("Your ID is "+account.getId()+" name is "+account.getName()+" and Balance is "+account.getBalance()+" and acc type "+account.getAccountType());
		

	}
	
	private static Account MaxBalance(Account[] accounts) {
		Account maxAccount = accounts[0];
		for (int i = 0; i < accounts.length; i++) {
			if (maxAccount.getBalance()<accounts[i].getBalance()) {
				maxAccount = accounts[i];
			}
		}
		return maxAccount;
	}
	
	private static Account maxBalanceInAccountType(Account[] accounts ,accountType type) {
		Account maxAccount = null;
		for (int i = 0; i < accounts.length; i++) {
			if(maxAccount==null && accounts[i].getAccountType().equals(type)) {
				maxAccount = accounts[i];
			}
			if(maxAccount!=null && accounts[i].getAccountType().equals(type) && maxAccount.getBalance()<accounts[i].getBalance()) {
				maxAccount = accounts[i];
			}
		}
		return maxAccount;
	}
	
	private static double totalBalance(Account[] accounts) {
		double total=0;
		for (int i = 0; i < accounts.length; i++) {
			total+=accounts[i].getBalance();
		}
		return total;
	}
	
	private static double totalBalanceOfSavings(Account[] accounts,accountType type) {
		double total=0;
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getAccountType().equals(type)) {
				total+=accounts[i].getBalance();
			}
		}
		return total;
	}
	
	private static void sortAccounts(Account[] accounts) {
		Account temp = null;
		for (int i = 0; i < accounts.length; i++) {
			for (int j = i; j < accounts.length; j++) {
				if (accounts[i].getBalance()<accounts[j].getBalance()) {
					temp = accounts[i];
					accounts[i]=accounts[j];
					accounts[j]=temp;
				}
			}
		}
		
	}

}
