package com.aurionpro.test;

import com.aurionpro.model.Account;

import com.aurionpro.exception.TransationFailed;
import com.aurionpro.model.Account;

public class AccountTest {
	public static void main(String[] args) {

		Account account = new Account(111, "Tanuja", 1500);
		try {
			Account.withdraw(account, 2000);
		} catch (TransationFailed e) {
			System.out.println(e.getMessage());
		}
	}

}
