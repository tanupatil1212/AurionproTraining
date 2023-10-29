package com.aurionpro.dao;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentDao {

	
	public void saveStudent(Student student);

	
		public Student findStudentById(int id);
		
		public List<Student> findAll();


		public void deleteStudentById(int id);


		public List<Student> findStudentByFirstName(String firstName);
		
		List<Student> findStudentByFirstName(String firstName, String lastName);
		List<Student> findStudentByEmailId(String emailId);
		void updateStudent(Student student);


	
	
}
