package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.service.StudentService;

@RestController
@RequestMapping("/apiv1")
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable int studentId) throws StudentNotFoundException {
		return new ResponseEntity<>(service.findStudentById(studentId), HttpStatus.OK);
	}

	@PostMapping("/students")
	public ResponseEntity<Student> addNewStudent(@RequestBody Student student) throws StudentNotFoundException {
		return new ResponseEntity<>(service.save(student), HttpStatus.CREATED);
	}

	@PutMapping("/students")
	public ResponseEntity<Student> UpdateStudent(@RequestBody Student student) {
		return new ResponseEntity<>(service.save(student), HttpStatus.OK);
	}

	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int studentId) throws StudentNotFoundException {
		service.deleteStudentById(studentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	@ExceptionHandler
//	public ResponseEntity<StudentExceptionResponse> handleResponse(StudentNotFoundException e)
//	{
//		StudentExceptionResponse error = new StudentExceptionResponse();
//		error.setStatus		(HttpStatus.NOT_FOUND.value());
//		error.setMessage	(	e.getMessage()			 );
//		error.setTimeStamp	(System.currentTimeMillis()	 );
//		
//		
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND); 
//	}
//	@ExceptionHandler
//	public ResponseEntity<StudentExceptionResponse> handleResponse(MethodArgumentTypeMismatchException e)
//	{
//		StudentExceptionResponse error = new StudentExceptionResponse();
//		error.setStatus		(HttpStatus.BAD_REQUEST.value());
//		error.setMessage	(	"Input type mismatched"    );
//		error.setTimeStamp	(System.currentTimeMillis()	   );
//		
//		
//		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST); 
//	}

}
