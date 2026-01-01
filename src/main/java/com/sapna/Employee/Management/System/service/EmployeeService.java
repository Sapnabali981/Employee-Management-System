package com.sapna.Employee.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sapna.Employee.Management.System.entity.Employee;


public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);
	
	Employee updateEmployee(int id, Employee employee);

	void deleteEmployee(int id);

	

}
