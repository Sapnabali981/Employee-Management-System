package com.sapna.Employee.Management.System.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	//let's update this class details inside the service layer as well.
}
