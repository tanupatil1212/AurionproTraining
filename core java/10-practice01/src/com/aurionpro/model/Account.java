package com.aurionpro.model;

public class Account {
	private int id;
	private String name;
	private double balance;
	private accountType type;
	
//	public Account(int id,String name,double balance,accountType type) {
//		this.id = id;
//		this.name = name;
//		this.balance = balance;
//		this.type = type;
//	}
	
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name =name;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public void setAccountType(accountType type){
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", type=" + type + "]";
	}
	public accountType getAccountType() {
		return type;
	}

}
