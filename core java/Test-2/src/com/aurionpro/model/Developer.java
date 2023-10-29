package com.aurionpro.model;

public class Developer extends Employee {
	private double pa;
	private double ot;
	
	public Developer(long employeeID, String name, double basic) {
		super(employeeID, name, basic);
	}

	public double getPa() {
		return pa;
	}

	public void setPa(double pa) {
		this.pa = pa;
	}

	public double getOt() {
		return ot;
	}

	public void setOt(double ot) {
		this.ot = ot;
	}

	@Override
	public double CalculateCTC(double salary) {
		// TODO Auto-generated method stub
		setPa(salary*40/100);
		setOt(salary*20/100);
		System.out.println("Salary "+getBasic()+" OT : "+getOt()+" OT "+getOt());
		return salary+getPa()+getOt();
	}

	@Override
	public String toString() {
		return "Developer [pa=" + pa + ", ot=" + ot + "]";
	}

}
