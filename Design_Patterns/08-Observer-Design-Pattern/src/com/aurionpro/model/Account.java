package com.aurionpro.model;

import java.util.List;

import javax.naming.InsufficientResourcesException;

public class Account {

	 private int accountNumber;
	    private String name;
	    private double balance;
	    private List<INotifier> notifiers;

	    public Account(int accountNumber, String name, double balance, List<INotifier> notifiers) {
	        this.accountNumber = accountNumber;
	        this.name = name;
	        this.balance = balance;
	        this.notifiers = notifiers;
	    }

	    
	    // Getters and setters

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


		public List<INotifier> getNotifiers() {
			return notifiers;
		}


		public void setNotifiers(List<INotifier> notifiers) {
			this.notifiers = notifiers;
		}


		public void deposit(double amount) {
	        // Implement deposit logic here
	        this.balance += amount;
	    }

	    public void withdraw(double amount) throws InsufficientBalanceException {
	        if (balance - amount >= 0) {
	            balance -= amount;
	            for (INotifier x : notifiers) {
	                x.notifyUser(this, amount, TransactionType.WITHDRAW);
	            }
	        } else {
	            throw new InsufficientBalanceException("Insufficient Funds");
	        }
	    }

	    public void registerNotifier(INotifier notifier) {
	        notifiers.add(notifier);
	    }


		@Override
		public String toString() {
			return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance
					+ ", notifiers=" + notifiers + "]";
		}
	    
	    
}
