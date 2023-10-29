package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;

public interface StudentService {
	List<Student> findAll();


	Student findStudentById(int studentId) throws StudentNotFoundException;


	Student save(Student student);


	void deleteStudentById(int studentId) throws StudentNotFoundException;

}
