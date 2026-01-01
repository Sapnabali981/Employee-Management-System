package com.sapna.Employee.Management.System.exception;

public class EmployeeAlreadyDeletedException extends RuntimeException {
	
	public EmployeeAlreadyDeletedException(String message) {
		super(message);
	}
}
