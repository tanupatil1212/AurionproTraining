package com.aurionpro.model;

public class Employee {
	private int id;
	private String name;
	private double basic;
	private double hra;
	private double da;
	private double ta;
	

	public Employee(int id, String name, double basic) {
		this.id = id;
		this.name = name;
		this.basic = basic;
		this.hra = 0.20 * basic;
		this.da = 0.15 * basic;
		this.ta = 0.10 * basic;
	}
	
	 public double calculateTotalSalary() {
	        return basic + hra + da + ta;
	    }

	    public double calculateTax() {
	        double totalSalary = calculateTotalSalary();
	        if (totalSalary >= 500000 && totalSalary < 800000) {
	            return 0.10 * totalSalary;
	        } else if (totalSalary >= 800000 && totalSalary < 1000000) {
	            return 0.20 * totalSalary;
	        } else if (totalSalary >= 1000000) {
	            return 0.30 * totalSalary;
	        } else {
	            return 0;
	        }
	    }

	    public void printSalarySlip() {
	        System.out.println("Employee ID: " + id);
	        System.out.println("Employee Name: " + name);
	        System.out.println("Basic Salary: " + basic);
	        System.out.println("HRA: " + hra);
	        System.out.println("DA: " + da);
	        System.out.println("TA: " + ta);
	        System.out.println("Total Salary: " + calculateTotalSalary());
	        System.out.println("Tax Deducted: " + calculateTax());
	        System.out.println("Net Salary: " + (calculateTotalSalary() - calculateTax()));
	    }

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", basic=" + basic + ", hra=" + hra + ", da=" + da
					+ ", ta=" + ta + "]";
		}
	    
}
