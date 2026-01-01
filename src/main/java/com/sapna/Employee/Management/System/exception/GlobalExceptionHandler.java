package com.sapna.Employee.Management.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleException(EmployeeNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmployeeAlreadyActiveException.class)
	public ResponseEntity<String> handlingActiveEmployeeException(EmployeeAlreadyActiveException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleillegalArgumentException(IllegalArgumentException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EmployeeAlreadyDeletedException.class)
	public ResponseEntity<String> handleEmployeeAlreadyDeletedException(EmployeeAlreadyDeletedException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}