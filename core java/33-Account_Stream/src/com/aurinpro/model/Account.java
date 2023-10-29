package com.aurinpro.model;

public class Account {
	private int id;
	private String name;
	private double balance;
	private Gender gender;

	public Account(int id, String name, double balance, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "\nAccount [id=" + id + ", name=" + name + ", balance=" + balance + ", gender=" + gender + "]";
	}

}
