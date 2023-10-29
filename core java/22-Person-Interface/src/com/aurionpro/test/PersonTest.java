package com.aurionpro.test;

import java.time.LocalDate;

import com.aurionpro.model.Person;
import com.aurionpro.model.Professor;
import com.aurionpro.model.Student;

public class PersonTest {
	public static void main(String[] args) {
		Student student=new Student(10,"thane",LocalDate.of(2000, 7, 9),"IT");
		  System.out.println(student.toString());
		  
		  Professor prof=new Professor(13,"mumbai",LocalDate.of(2000, 07, 7),1000);
		  System.out.println(prof.toString());
		 
		 

	}
}
