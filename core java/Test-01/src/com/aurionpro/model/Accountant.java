package com.aurionpro.model;

public abstract class Accountant extends Employee {
	private double hra;
	private double ma;
	
	public Accountant(Long employeeId, String name, double basic) {
		super(employeeId, name, basic);
		// TODO Auto-generated constructor stub
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getMa() {
		return ma;
	}
	public void setMa(double ma) {
		this.ma = ma;
	}
	
	@Override
	public double CalculateAnnualCTC (double salary) {
		this.hra= (40/100)*salary;
		this.ma = (25/100)*salary;
		
		double annualCTCforAccountant = salary +  this.hra+this.ma;
		return annualCTCforAccountant ;
		
	}
	
	

}
