package com.aurionpro.test;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String args[]) {
		Student student = new Student();
		
		student.id=10;
		student.name="Tanuja";
		student.emailid="tanujagmail.com";
		student.percentage=90;
	
		System.out.println("Id :" + student.id +" " + "Name: "+ student.name );
		
	}
	

}
