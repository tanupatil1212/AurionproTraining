package com.aurionpro.model;

public class Accountant extends Employee {
	private double hra;
	private double ma;
	
	
	public Accountant(long employeeID, String name, double basic) {
		super(employeeID, name, basic);

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
	public double CalculateCTC(double salary) {
		// TODO Auto-generated method stub
		setHra(salary*25/100);
		setMa(salary*20/100);
		System.out.println("Salary "+getBasic()+" HRA: "+getHra()+" MA "+getMa());
		return salary+getHra()+getMa();
	}


	@Override
	public String toString() {
		return "Accountant [hra=" + hra + ", ma=" + ma + "]";
	}
}
