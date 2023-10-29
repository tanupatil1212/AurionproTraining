package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.StudentRepository;
import com.aurionpro.service.StudentService;

@RestController
@RequestMapping("/apiv1")
public class StudentController {

	private StudentService service;
	@Autowired
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	
	

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return service.findAll();
	}

	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		return (Student) service.findById(studentId);

	}

	@PostMapping("/students")
	public Student addNewStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

//	@DeleteMapping("/students/{studentId}")
//	public void deleteStudent(@PathVariable int studentId) {
//		service.deleteStudentById(studentId);
//	}

}
