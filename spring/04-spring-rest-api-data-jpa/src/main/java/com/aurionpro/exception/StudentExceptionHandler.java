package com.aurionpro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class StudentExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleResponse(StudentNotFoundException e)
	{
		StudentExceptionResponse error = new StudentExceptionResponse();
		error.setStatus		(HttpStatus.NOT_FOUND.value());
		error.setMessgae	(	e.getMessage()			 );
		error.setTimeStamp	(System.currentTimeMillis()	 );
		
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND); 
	}
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleResponse(MethodArgumentTypeMismatchException e)
	{
		StudentExceptionResponse error = new StudentExceptionResponse();
		error.setStatus		(HttpStatus.BAD_REQUEST.value());
		error.setMessgae	(	"Input type mismatched"    );
		error.setTimeStamp	(System.currentTimeMillis()	   );
		
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST); 
	}

}
