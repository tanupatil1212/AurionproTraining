package com.aurionpro.model;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class EmployeeManager {
	

		List<Employee> empDetails  = new ArrayList<Employee>();
		static final String filepath = "D:\\Aurionpro\\core java\\Test_Employee\\emp.txt";
		
		

		public void loadData() {
			loadEmpData();
		}
		
		public void convertToEmpObj() {
			try {
				BufferedReader br = new BufferedReader(new FileReader("D:\\\\Aurionpro\\\\core java\\\\Test_Employee\\\\emp.txt"));
				String line = br.readLine();
				Double commission;
				int managerID;
				while (line != null) {
					String[] arr = line.split(",");
					if (arr.length == 8) {
//						for (String string : arr) {
//							System.out.println(string);
//						}
						int empID = Integer.parseInt(arr[0].trim().replaceAll("\"", ""));
						String name = arr[1].trim().replace("\"", "");
						String role = arr[2].trim().replace("\"", "");
						if (arr[3].equalsIgnoreCase("null")) {
							managerID = 0;
						} else {
							managerID = Integer.parseInt(arr[3].trim().replaceAll("\"", ""));
						}
						String date = arr[4].trim().replace("\"", "");
						if (arr[6].equalsIgnoreCase("null")) {
							commission = (double) 0;
						} else {
							commission = Double.parseDouble(arr[6].trim().replace("\"", ""));
						}
						double salary = Double.parseDouble(arr[5].trim().replace("\"", ""));
						int departmentID = Integer.parseInt(arr[7].trim().replace("\"", ""));
						empDetails.add(new Employee(empID, name, role, managerID, date, salary, commission, departmentID));
						System.out.println(empDetails);
//						
					}
					line = br.readLine();
				
			} 
			}catch (IOException e) {
			
				e.printStackTrace();
			}
			
		}
		
		public void serializeData() {
			try {
				FileOutputStream file = new FileOutputStream(filepath);
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(empDetails);
				out.close();
				file.close();

//		            System.out.println("Object has been serialized");
				loadEmpData();

			}

			catch (IOException ex) {
				System.out.println("IOException is caught");
			}
		}

		private void loadEmpData() {
			
			try {

				FileInputStream file = new FileInputStream(filepath);
				ObjectInputStream in = new ObjectInputStream(file);

				empDetails = (List<Employee>) in.readObject();

				in.close();
				file.close();
			}

			catch (IOException ex) {
				System.out.println("IOException is caught");
			}

			catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFoundException" + " is caught");
			}
		}
		
		public void addNewEmp() {
			System.out.println("Enter Employee ID");
			Scanner userin = new Scanner(System.in);
			int empID = userin.nextInt();
			userin.nextLine();
			System.out.println("Enter name the Employee Name");
			String name = userin.nextLine();
			System.out.println("Enter Employee role");
			String role = userin.nextLine();
			System.out.println("Enter manager ID");
			int managerID = userin.nextInt();
			userin.nextLine();
			System.out.println("Enter date Of Joining");
			String date = userin.nextLine();
			System.out.println("Enter the salary of the employee ");
			double salary = userin.nextDouble();
//			userin.nextLine();
			System.out.println("Enter Commission");
			double commission = userin.nextDouble();
			System.out.println("Enter department id");
			int department = userin.nextInt();
			
			empDetails.add(new Employee(empID, name, role, managerID, date, salary, commission, department));
			serializeData();
			
		}
		public void getAllEmp() {
			
			loadEmpData();
			for (Employee employee : empDetails) {
				System.out.println(employee);
			}
		}
		
		public void getAllFromDepartment() {
		    loadEmpData();
		    System.out.println("Enter department id:");
		    Scanner userin = new Scanner(System.in);
		    int userinput = userin.nextInt();

		    empDetails.stream()
		              .filter(employee -> employee.getDepartmentID() == userinput)
		              .forEach(System.out::println);
		}

		
		public void countOfEmpInEachDepartment() {
		    loadEmpData();
		    
		    Map<Integer, Long> departmentCount = empDetails.stream()
		            .collect(Collectors.groupingBy(Employee::getDepartmentID, Collectors.counting()));

		    departmentCount.forEach((departmentID, count) -> 
		        System.out.println("In department " + departmentID + " there are " + count + " employees.")
		    );
		}

		
		
		
		public void deleteEmp() {
		    loadEmpData();
		    Scanner userin = new Scanner(System.in);
		    System.out.println("Enter emp ID to delete");
		    int userinput = userin.nextInt();

		    empDetails.removeIf(employee -> employee.getEmployeeID() == userinput);

		    System.out.println("Removed");
		    serializeData();
		}

		
		public void getManagerOfEmp() {
		    loadEmpData();
		    System.out.println("Enter Employee ID to get manager info");
		    Scanner userin = new Scanner(System.in);
		    int userinput = userin.nextInt();

		    Optional<Employee> employeeWithID = empDetails.stream()
		            .filter(employee -> employee.getEmployeeID() == userinput)
		            .findFirst();

		    employeeWithID.ifPresent(employee -> {
		        empDetails.stream()
		                .filter(e -> e.getEmployeeID() == employee.getManagerID())
		                .forEach(System.out::println);
		    });
		}

		
		
		
		
		public void sumOfAllSalaries() {
		    loadEmpData();
		    
		    double totalSalary = empDetails.stream()
		            .map(Employee::getSalary)
		            .reduce(0.0, Double::sum);

		    System.out.println("Total salary of the company is " + totalSalary);
		}
		
		public void Deserializeemployeesfromthefile() {
		    try {
		        FileInputStream file = new FileInputStream(filepath);
		        ObjectInputStream in = new ObjectInputStream(file);

		        empDetails = (List<Employee>) in.readObject();

		        in.close();
		        file.close();

		        System.out.println("Employees deserialized from the file.");
		    } catch (IOException ex) {
		        System.out.println("IOException is caught: " + ex.getMessage());
		    } catch (ClassNotFoundException ex) {
		        System.out.println("ClassNotFoundException is caught: " + ex.getMessage());
		    }
		}
		
		public void Findtheimmediatemanageroftheemployee() {
		    loadEmpData();
		    
		    System.out.println("Enter Employee ID to find the immediate manager:");
		    Scanner userin = new Scanner(System.in);
		    int userinput = userin.nextInt();

		    Optional<Employee> employee = empDetails.stream()
		            .filter(e -> e.getEmployeeID() == userinput)
		            .findFirst();

		    employee.ifPresent(e -> {
		        int managerID = e.getManagerID();
		        Optional<Employee> manager = empDetails.stream()
		                .filter(m -> m.getEmployeeID() == managerID)
		                .findFirst();
		        
		        manager.ifPresent(m -> System.out.println("Immediate manager of Employee " + e.getEmployeeID() + " is: " + m));
		        if (!manager.isPresent()) {
		            System.out.println("Employee " + e.getEmployeeID() + " doesn't have an immediate manager.");
		        }
		    });
		    
		    if (!employee.isPresent()) {
		        System.out.println("Employee with ID " + userinput + " not found.");
		    }
		}
		
		public void Findhighestpaidemployeeineachdepartment() {
		    loadEmpData();
		    
		    Map<Integer, Employee> highestPaidByDepartment = new HashMap<>();

		    for (Employee employee : empDetails) {
		        int departmentID = employee.getDepartmentID();
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
		    loadEmpData();
		    
		    Map<String, Employee> highestPaidByRole = new HashMap<>();

		    for (Employee employee : empDetails) {
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
		
		public void Findemployeesjoinedbetweentwodates() {
		    loadEmpData();
		    
		    Scanner scanner = new Scanner(System.in);
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    
		    System.out.println("Enter start date (yyyy-MM-dd):");
		    String startDateStr = scanner.nextLine();
		    System.out.println("Enter end date (yyyy-MM-dd):");
		    String endDateStr = scanner.nextLine();
		    
		    try {
		        Date startDate = dateFormat.parse(startDateStr);
		        Date endDate = dateFormat.parse(endDateStr);
		        
		        empDetails.stream()
		                .filter(employee -> {
		                    try {
		                        Date joinDate = dateFormat.parse(employee.getDateOfJoining());
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
		    loadEmpData();
		    
		    Optional<Employee> salesmanWithHighestCommission = empDetails.stream()
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



