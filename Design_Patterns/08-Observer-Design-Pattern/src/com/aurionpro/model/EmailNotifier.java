package com.aurionpro.model;

public class EmailNotifier implements INotifier {

	@Override
	public void notifyUser(Account account,double amount,TransactionType type) {
		System.out.println("Email notifier");
		System.out.println("Transaction:" + type.toString().toLowerCase());
		System.out.println("Amount"+amount);
		System.out.println("Amount balance" + account.getBalance());
		System.out.println("******" );

	}

}
