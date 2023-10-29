package com.aurionpro.model;

import java.util.List;
import java.util.Scanner;
import com.aurionpro.model.Employee;

public class EmplyeeController {
	
	    private EmployeeManager employeeManager;

	    public EmplyeeController() {
	        employeeManager = new EmployeeManager();
	    }

	    public void start() {
	        displayMenu();
	    }

	    public void displayMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.println("1. Add Employee");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    Employee newEmployee = setEmployeeDetails();
	                    employeeManager.addEmployee(newEmployee);
	                    System.out.println("Employee added Successfully");
	                    break;
	                case 2:
	                	
	            }
	        } while (choice != 5);
	    }




	
	

}
