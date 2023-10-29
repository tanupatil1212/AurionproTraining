package com.aurionpro.test;

import com.aurionpro.model.Employee;

import com.aurionpro.model.Manager;
import com.aurionpro.model.Devloper;

public  class EmployeeTest {
	public static void main(String[] args) {
		Employee employee = new Employee(10,"tanuja",1200);
		printSalarySlip(Employee);
	}
	
	
	
	private static void printSalarySlip(Employee employee) {
		System.out.println(employee.toString());
		System.out.println("Annual CTC"+employee.CalculateAnnualCTC());
		
		
		
		
						
						
		
				
				
		}
}

