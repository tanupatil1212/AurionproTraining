package com.aurionpro.test;

import java.util.ArrayList;

import com.aurionpro.model.Account;
import com.aurionpro.model.InsufficientBalanceException;
import com.aurionpro.model.SmsNotifier;

public class AccountTest {

	public static void main(String[] args) {
		
		Account account = new Account(111, "Tanuja", 5444, new ArrayList<>());
		account.registerNotifier(new SmsNotifier());
		try {
			account.withdraw(10000);
		} catch (InsufficientBalanceException e) {
			System.out.println("trancation declined"+e.getMessage());
			System.out.println("***********");
			
			System.out.println(account);
		}
		account.deposit(3000);
		
	}

}
