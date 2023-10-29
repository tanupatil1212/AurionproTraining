package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.aurionpro.model.Accounts;




public class AccountsTest {
	public static void main(String[] args) {
		List<Accounts> accounts = new ArrayList<>();
		
		accounts.add(new Accounts(01, "Tanuja", 2000));
		accounts.add(new Accounts(02, "Sneha", 3455));
		accounts.add(new Accounts(03, "Namrata", 34566));
		accounts.add(new Accounts(04, "Sejal", 45333));
		accounts.add(new Accounts(05, "sita", 24233));
		
		System.out.println(accounts);
		
		for(Accounts account:accounts) {
			System.out.println(account.getName());
		}
		
		Iterator<Accounts> iterator = accounts.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getBalance());
		}
	}

}
