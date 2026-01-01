package com.sapna.Employee.Management.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String department;
	private String email;
	private double salary;
	
	private boolean deleted = false;//for soft delete 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee() {
		super();
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	/*
	 * validation means here we are preventing the wrong data/invalida data of user before hitting in db.
	 * here we will be writing the validation code inside the service layer. because service layer will contain all the business logic.
	 * input validation means here name email should not be empty as well here salary should be greater than 0.
	 * if not then we have to throw an exception of illegalArugumentException. which needs to be handled with custom exception message with proper http status code inside the global exception handler class.
	 * 
	 */
	
}
