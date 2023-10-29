package com.aurionpro.test;

import com.aurionpro.model.Accountant;
import com.aurionpro.model.Developer;
import com.aurionpro.model.Employee;
import com.aurionpro.model.Manager;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Manager manager = new Manager(10009, "Cyno", 40000);
		printSalarySlip(manager);

		Accountant account = new Accountant(1006, "ABC", 9000);
		printSalarySlip(account);

		Developer dev = new Developer(110, "ajc", 90000);
		printSalarySlip(dev);
	}

	public static void printSalarySlip(Employee obj){
//		return null;
		System.out.println(obj.CalculateCTC(obj.getBasic()));
	}
}