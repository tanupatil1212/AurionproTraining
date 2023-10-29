package com.aurionpro.model;

public class TaxUtil {
	public double calculateTax(Employee employee) {
		double totalSalary = employee.calculateTotalSalary()*12;
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

}
