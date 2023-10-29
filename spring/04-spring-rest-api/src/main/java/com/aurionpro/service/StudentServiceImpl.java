package com.aurionpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository repository;

	public StudentServiceImpl(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Student> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Student findById(int studentId) {
		// TODO Auto-generated method stub
		return repository.findById(studentId);
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return repository.saveStudent(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Student updateStudent(Student student) {
//		// TODO Auto-generated method stub
//		return repository.updateStudent(student);
//	}

//	@Override
//	public void deleteStudentById(int studentId) {
//		return repository.deleteStudentById(studentId);
//		
//	}

}
