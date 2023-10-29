package com.aurionpro.model;


import com.aurionpro.exception.TransationFailed;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
	public static void withdraw(Account account,double amount) {
		if(account.getBalance()-amount>1000) {
			account.setBalance(account.getBalance()-amount);
			
		}
		else {
			throw new TransationFailed("Transaction Failed Insufficient balance current balance is "+account.getBalance()+" withdraw amount is "+amount);
		}
	}

	
	
	

}
