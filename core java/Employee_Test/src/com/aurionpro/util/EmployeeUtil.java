package com.aurionpro.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aurionpro.model.Employee;

public class EmployeeUtil {
	
	List<Employee> employeeList;
	private static boolean initialLoad = false;

	public EmployeeUtil() {
		this.employeeList = new ArrayList<>();
		loadEmployee();
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	private void loadEmployee() {
		if (checkIfFileEmpty() && !initialLoad) {
			employeeList = new EmployeeReader().readEmployeeFromFile("D:\\Aurionpro\\core java\\Employee_Test\\emp.txt");
			initialLoad = true;
		} else if (!checkIfFileEmpty()) {
			try {
				FileInputStream file = new FileInputStream("D:\\Aurionpro\\core java\\Employee_Test\\emp-serialize.txt");
				ObjectInputStream in = new ObjectInputStream(file);

				this.employeeList = (List<Employee>) in.readObject();

				in.close();
				file.close();

				System.out.println("Object de-serialized successfully");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
		saveEmployeeList();
	}

	public void removeEmployee(Employee employee) {
		if (employeeList.contains(employee)) {
			employeeList.remove(employee);
			saveEmployeeList();
		}

	}

	private void saveEmployeeList() {
		try {
			FileOutputStream file = new FileOutputStream("D:\\Aurionpro\\core java\\Employee_Test\\emp-serialize.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(employeeList);

			out.close();
			file.close();

			System.out.println("Object serialized successfully");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean checkIfFileEmpty() {
		try {
			FileInputStream file = new FileInputStream("D:\\Aurionpro\\core java\\Employee_Test\\emp-serialize.txt");
			if (file.read() != -1) {
				return false;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void getAllFromDepartment() {
		loadEmployee();
	    System.out.println("Enter department id:");
	    Scanner userin = new Scanner(System.in);
	    int userinput = userin.nextInt();

	    employeeList.stream()
	              .filter(employee -> employee.getDepartmentId() == userinput)
	              .forEach(System.out::println);
	}
	
	public void countOfEmpInEachDepartment() {
		loadEmployee();
	    
	    Map<Integer, Long> departmentCount = employeeList.stream()
	            .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.counting()));

	    departmentCount.forEach((departmentID, count) -> 
	        System.out.println("In department " + departmentID + " there are " + count + " employees.")
	    );
	}

	
	
	
//	public void deleteEmp() {
//		loadEmployee();
//	    Scanner userin = new Scanner(System.in);
//	    System.out.println("Enter emp ID to delete");
//	    int userinput = userin.nextInt();
//
//	    employeeList.removeIf(employee -> employee.getId() == userinput);
//
//	    System.out.println("Removed");
//	    serializeData();
//	}

	
	public void getManagerOfEmp() {
		loadEmployee();
	    System.out.println("Enter Employee ID to get manager info");
	    Scanner userin = new Scanner(System.in);
	    int userinput = userin.nextInt();

	    Optional<Employee> employeeWithID = employeeList.stream()
	            .filter(employee -> employee.getId() == userinput)
	            .findFirst();

	    employeeWithID.ifPresent(employee -> {
	    	employeeList.stream()
	                .filter(e -> e.getId() == employee.getManagerId())
	                .forEach(System.out::println);
	    });
	}

	
	
	
	
	public void sumOfAllSalaries() {
		loadEmployee();
	    
	    double totalSalary = employeeList.stream()
	            .map(Employee::getSalary)
	            .reduce(0.0, Double::sum);

	    System.out.println("Total salary of the company is " + totalSalary);
	}
	
	
	
	public void Findtheimmediatemanageroftheemployee() {
		loadEmployee();
	    
	    System.out.println("Enter Employee ID to find the immediate manager:");
	    Scanner userin = new Scanner(System.in);
	    int userinput = userin.nextInt();

	    Optional<Employee> employee = employeeList.stream()
	            .filter(e -> e.getId() == userinput)
	            .findFirst();

	    employee.ifPresent(e -> {
	        int managerID = e.getId();
	        Optional<Employee> manager = employeeList.stream()
	                .filter(m -> m.getId() == managerID)
	                .findFirst();
	        
	        manager.ifPresent(m -> System.out.println("Immediate manager of Employee " + e.getId() + " is: " + m));
	        if (!manager.isPresent()) {
	            System.out.println("Employee " + e.getId() + " doesn't have an immediate manager.");
	        }
	    });
	    
	    if (!employee.isPresent()) {
	        System.out.println("Employee with ID " + userinput + " not found.");
	    }
	}
	
	public void Findhighestpaidemployeeineachdepartment() {
		loadEmployee();
	    
	    Map<Integer, Employee> highestPaidByDepartment = new HashMap<>();

	    for (Employee employee : employeeList) {
	        int departmentID = employee.getDepartmentId();
	        if (!highestPaidByDepartment.containsKey(departmentID) ||
	            employee.getSalary() > highestPaidByDepartment.get(departmentID).getSalary()) {
	            highestPaidByDepartment.put(departmentID, employee);
	        }
	    }

	    highestPaidByDepartment.forEach((departmentID, employee) -> 
	        System.out.println("Highest paid employee in Department " + departmentID + ": " + employee)
	    );
	}
	
	public void Findhighestpaidemployeeoneachrole() {
		loadEmployee();
	    
	    Map<String, Employee> highestPaidByRole = new HashMap<>();

	    for (Employee employee : employeeList) {
	        String role = employee.getRole();
	        if (!highestPaidByRole.containsKey(role) ||
	            employee.getSalary() > highestPaidByRole.get(role).getSalary()) {
	            highestPaidByRole.put(role, employee);
	        }
	    }

	    highestPaidByRole.forEach((role, employee) -> 
	        System.out.println("Highest paid employee in Role " + role + ": " + employee)
	    );
	}
	
	public void findEmployeesJoinedBetweenTwoDates() {
	    loadEmployee();

	    Scanner scanner = new Scanner(System.in);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	    System.out.println("Enter start date (yyyy-MM-dd):");
	    String startDateStr = scanner.nextLine();
	    System.out.println("Enter end date (yyyy-MM-dd):");
	    String endDateStr = scanner.nextLine();

	    try {
	        Date startDate = dateFormat.parse(startDateStr);
	        Date endDate = dateFormat.parse(endDateStr);

	        employeeList.stream()
	            .filter(employee -> {
	                try {
	                    Date joinDate = dateFormat.parse(employee.getDateOfJoining().toString()); // Assuming getDateOfJoining() returns a LocalDate
	                    return joinDate.after(startDate) && joinDate.before(endDate);
	                } catch (ParseException e) {
	                    return false;
	                }
	            })
	            .forEach(System.out::println);
	    } catch (ParseException e) {
	        System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
	    }
	}

	public void Findsalesmanwithhighestcommission() {
		loadEmployee();
	    
	    Optional<Employee> salesmanWithHighestCommission = employeeList.stream()
	            .filter(employee -> employee.getRole().equalsIgnoreCase("salesman"))
	            .max(Comparator.comparingDouble(Employee::getCommission));

	    salesmanWithHighestCommission.ifPresent(employee ->
	        System.out.println("Salesman with highest commission: " + employee)
	    );

	    if (!salesmanWithHighestCommission.isPresent()) {
	        System.out.println("No salesman with commission found.");
	    }
	}



}
