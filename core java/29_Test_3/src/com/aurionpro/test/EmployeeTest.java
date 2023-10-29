package com.aurionpro.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Employee;

public class EmployeeTest {

            public static void main(String args[]) { 
            	  Employee emplyee = new Employee(); 
            	  List<Employee> employees = Arrays.asList( 
            	   new Employee(7698,"BLAKE","MANAGER",7839,"1-MAY-8",2850,null,30), 
            	   new Employee(7369,"SMITH","CLER",7902,"17-DEC-80",800,null,20), 
            	   new Employee(7788,"SCOTT","ANALYST",7566,"09-DEC-82",3000,null,20), 
            	   new Employee(7934,"MILLER","CLERK",7782,"23-JAN-82",1300,null,10) 
            	   ); 
            	    
            	
            	  Scanner sc = new Scanner(System.in); 
            	  System.out.println("Enter Department Id"); 
            	  int deptId = sc.nextInt(); 
            	  //1 
            	  List<Employee> collect = employees.stream().filter((emp) -> emp.getDeptID() == deptId).collect(Collectors.toList()); 
            	  System.out.println(collect); 
            	  //2 
            	  long count = employees.stream().filter((emp) -> emp.getDeptID() == 10).count(); 
            	  System.out.println(count); 
            	   
            	  long count1 = employees.stream().filter((emp) -> emp.getDeptID() == 20).count(); 
            	  System.out.println(count1); 
            	   
            	  long count2 = employees.stream().filter((emp) -> emp.getDeptID() == 30).count(); 
            	  System.out.println(count2); 
            	   
            	  System.out.println("Enter Employee ID for Deletion:"); 
            	  int empID = sc.nextInt(); 
          
            	  for(Employee emp: employees) { 
            	   emp.getEmpID() == emp 
            	  }

      
        }
    }