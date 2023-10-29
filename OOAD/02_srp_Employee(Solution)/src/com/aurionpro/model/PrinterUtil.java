package com.aurionpro.model;

public class PrinterUtil {
	public void printSalarySlip(Employee employee) {
		double tax = new TaxUtil().calculateTax(employee)/12;
		System.out.println("Employee ID: " + employee.getId());
		System.out.println("Employee Name: " + employee.getName());
		System.out.println("Basic Salary: " + employee.getBasic());
		System.out.println("HRA: " + employee.getHra());
		System.out.println("DA: " + employee.getDa());
		System.out.println("TA: " + employee.getTa());
		System.out.println("Total Salary: " + employee.calculateTotalSalary());
		System.out.println("Tax Deducted: " + tax);
		System.out.println("Net Salary: " + (employee.calculateTotalSalary() - tax / 12));
	}

}
