package com.aurionpro.model;

public class Devloper extends Employee  {
	
	public Devloper(Long employeeId, String name, double basic) {
		super(employeeId, name, basic);
		// TODO Auto-generated constructor stub
	}

	private double OT;
	private double PA;
	
	public double getOT() {
		return OT;
	}
	public void setOT(double oT) {
		OT = oT;
	}
	public double getPA() {
		return PA;
	}
	public void setPA(double pA) {
		PA = pA;
	}
	
	@Override
	public double CalculateAnnualCTC(){
		return (this.getBasic()+OT+PA*12);
	}
	
	@Override
	public String toString() {
		return "Devloper OT=" + OT + ", PA=" + PA ;
	}



}
