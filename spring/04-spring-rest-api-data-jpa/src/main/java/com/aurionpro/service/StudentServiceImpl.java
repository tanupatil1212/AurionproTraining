package com.aurionpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository repository;
	public StudentServiceImpl(StudentRepository repository) 
	{
		super();
		this.repository = repository;
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Student findStudentById(int studentId) throws StudentNotFoundException {
		return repository.findById(studentId).orElseThrow
				(
						()-> new StudentNotFoundException("Student not found with id="+studentId)
				);
	}

	@Override
	public Student save(Student student) {
		return repository.save(student);
		
	}

	@Override
	public void deleteStudentById(int studentId) throws StudentNotFoundException 
	{
		if(repository.existsById(studentId)) 
		{
			repository.deleteById(studentId);			
		}else {		throw new StudentNotFoundException("Student not found with id="+studentId);		}
	}

}