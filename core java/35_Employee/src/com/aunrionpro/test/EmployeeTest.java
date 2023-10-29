package com.aunrionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aunrionpro.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "tanuja", 467887, "HR"),
				new Employee(2, "sejal", 67765, "IT"), new Employee(3, "teju", 56766, "Comp"),
				new Employee(4, "nikum", 56766, "HR"), new Employee(5, "patil", 56766, "account"),
				new Employee(6, "tejas", 56766, "HR"), new Employee(7, "gigta", 56766, "HR"),
				new Employee(8, "rgds", 56774, "account"));

		// Map<String, List<Employee>> employeesByDepartment = employees.stream()
		// .collect(Collectors.groupingBy(Employee::getDepartment));
		//
		// for (Map.Entry<String, List<Employee>> entry :
		// employeesByDepartment.entrySet()) {
		// System.out.println("Department: " + entry.getKey());
		// for (Employee employee : entry.getValue()) {
		// System.out.println("Employee: " + employee.getName() + ", ID: " +
		// employee.getId());
		// }
		// System.out.println();
		// }

		//
		// List<String>collect = employees.stream()
		// .map((Employee)->Employee.getDepartment())
		// System.out.println(collect);
		List<Employee> maxBalance = employees.stream().sorted(Comparator.comparingDouble(Employee::getBalance).reversed())
				.limit(2).collect(Collectors.toList());
		System.out.println("Max three top Salary of Employee:");
		maxBalance.forEach(System.out::println);
		System.out.println("                                      ");

		List<Employee> minBalance = employees.stream().sorted(Comparator.comparingDouble(Employee::getBalance)).limit(2)
				.collect(Collectors.toList());
		System.out.println("Min three top Salary of Employee :");
		minBalance.forEach(System.out::println);
		System.out.println("                                 ");

	}

}
