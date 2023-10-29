
package example;

public class ok {
	
	import java.io.*;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.*;
	import java.util.stream.Collectors;

	class Employee {
	    int empId;
	    String empName;
	    String job;
	    int managerId;
	    Date hireDate;
	    int salary;
	    Integer commission;
	    int departmentId;

	    public Employee(int empId, String empName, String job, int managerId, Date hireDate, int salary, Integer commission, int departmentId) {
	        this.empId = empId;
	        this.empName = empName;
	        this.job = job;
	        this.managerId = managerId;
	        this.hireDate = hireDate;
	        this.salary = salary;
	        this.commission = commission;
	        this.departmentId = departmentId;
	    }

	    // Other getter and setter methods
	}

	public class EmployeeManagement {
	    private static List<Employee> employeeList = new ArrayList<>();

	    public static void main(String[] args) {
	        // Initialize employeeList with provided data

	        // Perform operations here
	        // For example:
	        findEmployeesInDepartment(30);
	        findEmployeeCountInEachDepartment();
	        // ... other operations

	        // Serialize and write to file
	        serializeToFile("employee_data.ser", employeeList);

	        // Deserialize and update the list
	        List<Employee> deserializedList = deserializeFromFile("employee_data.ser");
	        if (deserializedList != null) {
	            employeeList = deserializedList;
	        }
	    }

	    public static void findEmployeesInDepartment(int departmentId) {
	        List<Employee> employeesInDepartment = employeeList.stream()
	                .filter(employee -> employee.departmentId == departmentId)
	                .collect(Collectors.toList());

	        System.out.println("Employees in department " + departmentId + ":");
	        for (Employee employee : employeesInDepartment) {
	            System.out.println(employee.empName);
	        }
	    }

	    public static void findEmployeeCountInEachDepartment() {
	        Map<Integer, Long> employeeCountByDepartment = employeeList.stream()
	                .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.counting()));

	        System.out.println("Employee count in each department:");
	        for (Map.Entry<Integer, Long> entry : employeeCountByDepartment.entrySet()) {
	            System.out.println("Department " + entry.getKey() + ": " + entry.getValue());
	        }
	    }

	    public static void serializeToFile(String fileName, List<Employee> list) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
	            oos.writeObject(list);
	            System.out.println("Serialized data has been written to " + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static List<Employee> deserializeFromFile(String fileName) {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
	            List<Employee> list = (List<Employee>) ois.readObject();
	            System.out.println("Deserialized data has been read from " + fileName);
	            return list;
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}


}
