package com.aurionpro.test;

import com.aurionpro.util.EmployeeUtil;

public class EmployeeTest {
	static int count = 0;

	public static void main(String[] args) {
		

		
			
			EmployeeUtil employeeUtil = new EmployeeUtil();
			System.out.println(employeeUtil.getEmployeeList());
//			System.out.println("------3(ADD)----");
//			employeeUtil.addEmployee(new Employee(8010, "Rahul", "Manager", 3000, 7499, 0, 30));
//			System.out.println("----------------");
//			System.out.println(employeeUtil.getEmployeeList());
//			System.out.println("------3(Delete)----");
//			employeeUtil.removeEmployee();
			System.out.println("------1----");
			employeeUtil.getAllFromDepartment();
			System.out.println("------2----");
			employeeUtil.countOfEmpInEachDepartment();
			System.out.println("------5----");
			employeeUtil.getManagerOfEmp();
			
			System.out.println("------5----");
			employeeUtil.Findtheimmediatemanageroftheemployee();
			System.out.println("------6----");
			employeeUtil.Findhighestpaidemployeeineachdepartment();
			System.out.println("------7----");
			employeeUtil.Findhighestpaidemployeeoneachrole();
			System.out.println("------8----");
			employeeUtil.findEmployeesJoinedBetweenTwoDates();
			System.out.println("------9----");
			employeeUtil.Findsalesmanwithhighestcommission();
			System.out.println("------10----");
			employeeUtil.sumOfAllSalaries();
		
		
	

	}

}
