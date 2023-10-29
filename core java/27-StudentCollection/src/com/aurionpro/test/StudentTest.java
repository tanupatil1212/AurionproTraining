package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.aurionpro.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		List<Student> students=new ArrayList<>();
		  
		  students.add(new Student(11, "Tanuja", 95.5));
		  students.add(new Student(12, "Namrata", 67.9));
		  students.add(new Student(13, "Deepak", 98));
		  students.add(new Student(14, "Sneha", 45));
		  students.add(new Student(15, "Divya", 88));
		  
		//  for(Student x :students )
		//  System.out.println(x);
		  Student maxStudent=students.get(0);
		  for(Student x :students ) {
		   if(x.getPercentage()>maxStudent.getPercentage()) {
		    maxStudent=x;
		   }
		  }
		   System.out.println("Highest Percentage of student: " +maxStudent);
		   
		    students.sort(Comparator.comparingDouble(Student :: getPercentage).reversed());//reversed used for descending
		   for(Student x :students ) {
		    System.out.println("Sorting percentages according to descending order: " +x);
		   }
		  
		  students.sort(Comparator.comparing(Student :: getName));
		  for(Student x :students ) {
		   System.out.println("Sorting names according to names: " +x);
		  }
		 } 

	}


