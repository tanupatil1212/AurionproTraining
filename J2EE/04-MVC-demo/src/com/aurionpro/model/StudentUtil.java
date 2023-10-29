package com.aurionpro.model;
import java .util.*;

public class StudentUtil {
	 public List<Student> getAllStudents() {
		  List<Student> students=new ArrayList<Student>();
		  students.add(new Student(1,"Tanuja"  ,"tanuja@gmail.com"  ,60.0));
		  students.add(new Student(2,"Sneha" ,"sneha@gmail.com" ,95.0));
		  students.add(new Student(3,"Namrata"  ,"namrata@gmail.com"  ,85.0));
		  students.add(new Student(4,"Deepak" ,"deepak@gmail.com" ,97.0));
		  return students;
		 }

}
