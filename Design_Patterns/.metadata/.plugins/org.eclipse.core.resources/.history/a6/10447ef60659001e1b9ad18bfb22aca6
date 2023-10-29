package com.aurionpro.test;

import com.aurionpro.model.Consultant;
import com.aurionpro.model.Employee;
import com.aurionpro.model.SeniorConsultant;
import com.aurionpro.model.TechLead;

public class EmployeeTest {
	
	public static void main(String[] args) {
        
        Employee consultantEmployee = new Employee(1, "Consultant Employee", new Consultant());
        Employee seniorConsultantEmployee = new Employee(2, "Senior Consultant Employee", new SeniorConsultant());
        Employee techLeadEmployee = new Employee(3, "Tech Lead Employee", new TechLead());

       
        displayEmployeeInformation(consultantEmployee);
        displayEmployeeInformation(seniorConsultantEmployee);
        displayEmployeeInformation(techLeadEmployee);

        
        seniorConsultantEmployee.promote(new TechLead());

        
        displayEmployeeInformation(seniorConsultantEmployee);
    }

    public static void displayEmployeeInformation(Employee employee) {
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Role Description: " + employee.getDescription());
        System.out.println("Employee Role Responsibility: " + employee.getResponsibility());
        System.out.println();
    }

}
