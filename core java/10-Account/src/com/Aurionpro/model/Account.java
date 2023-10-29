package com.Aurionpro.model;

import com.Aurionpro.model.AccountType;

public class Account {
	
	private int id;
	private String name;
	private double balance;
	private  AccountType account;
	
	
	
	
	public Account(int id, String name, double balance, AccountType account) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.account = account;
	}


	//set method for the id
	public void   setID( int id)
	
	{
		this.id = id;
	}
	
	
	//set method for the name
    public void setName(String name)
	{
		this.name =name;
	}
    
  //set method for the balance
    public void setBalance(double balance)
	{
		this.balance =balance;
	}
    
    
  //set method for the Account Type
    public void setAccountType(AccountType account )
   	{
   		this.account =account;
   	}
    
    
    public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public AccountType getAccountType() {
		return account ;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", account=" + account + "]";
	}
	
	
	
	
  

}
