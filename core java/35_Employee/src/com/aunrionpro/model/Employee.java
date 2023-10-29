package com.aunrionpro.model;

public class Employee {
	private int id;
	private String name;
	private double balance;
	private String department;
	public Employee(int id, String name, double balance, String department) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.department = department;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", balance=" + balance + ", department=" + department + "]";
	}
	
	

}
