package com.aurionpro.test;
import com.aurionpro.model.Account;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingAccount;

public class AccountTest {

	public static void main(String[] args) {
//		Account acc1 = new Account(1, "Tanuja", 5000);
		Account acc2 = new SavingAccount(2, "Niharika", 3000);
		Account acc3 = new CurrentAccount(3, "Mahima", 5000);
		
		
		
//		acc1.deposit(2000);
		acc2.deposit(1000);
		acc3.deposit(1000);
		
//		System.out.println("Account after Deposit " + acc1.getBalance());
		System.out.println("Current Account after Deposit " + acc2);
		System.out.println("Savings Account after Deposit " + acc3);
		
		acc2.withdraw(2000);
		System.out.println(acc2);
		
		acc3.withdraw(2000);
		System.out.println(acc3);
		
		printAccountDetails(acc3);
		
		
		}
	public static void  printAccountDetails(Account account) {
//		System.out.println(account.Id);
//		System.out.println(account.Name);
//		System.out.println(account.Balance);
	}

}




