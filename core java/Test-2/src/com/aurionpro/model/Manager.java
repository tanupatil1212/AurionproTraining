package com.aurionpro.model;

public class Manager extends Employee{
	private double hra;
	private double da;
	private double ta;
	
	public Manager(long employeeID, String name, double basic) {
		super(employeeID, name, basic);
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}

	@Override
	public double CalculateCTC(double salary) {
		// TODO Auto-generated method stub
		setHra((salary*25/100));
		setDa((salary*15/100));
		setTa((salary*10/100));
		double ctc = salary+getHra()+getDa()+getTa();
		System.out.println("Salary "+getBasic()+" HRA: "+getHra()+" DA: "+getDa());
		return ctc;
	}


	

}