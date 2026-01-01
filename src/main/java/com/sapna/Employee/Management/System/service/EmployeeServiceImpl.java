package com.sapna.Employee.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapna.Employee.Management.System.entity.Employee;
import com.sapna.Employee.Management.System.exception.EmployeeAlreadyActiveException;
import com.sapna.Employee.Management.System.exception.EmployeeAlreadyDeletedException;
import com.sapna.Employee.Management.System.exception.EmployeeNotFoundException;
import com.sapna.Employee.Management.System.respository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepo;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		
		//validating user input.
		if(employee.getName()==null||employee.getName().trim().isEmpty()) {
			
		 throw new IllegalArgumentException("Employee name should not be null");
		}
		if(employee.getDepartment()==null||employee.getDepartment().trim().isEmpty()) {
			
			 throw new IllegalArgumentException("Employee department should not be null");
		}
		if(employee.getEmail()==null||employee.getEmail().trim().isEmpty()) {
			
			 throw new IllegalArgumentException("Employee email should not be null");
		}
		if(employee.getSalary()<=0) {
			
			 throw new IllegalArgumentException("Employee salary must be greater then 0");
		}
		
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> getEmployee = employeeRepo.findByDeletedFalse();
		return getEmployee;

	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> byId = employeeRepo.findById(id);

		return byId.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
		if(emp.isDeleted()==true) {
			throw new EmployeeAlreadyDeletedException("Cannot update a deleted employee");
		}
		employee.setId(id);
		return employeeRepo.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {

		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
		
		if(employee.isDeleted()==true) {
			throw new EmployeeAlreadyDeletedException("Employee is already deleted");
		}
		
		employeeRepo.softDeleteById(id);
		employeeRepo.save(employee);
	
		
        	
	}

	@Transactional
	public void restoreEmployee(int id) {
	
		
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
		
		if(emp.isDeleted()==false) {
			 throw new EmployeeAlreadyActiveException("Employee is already active with id: " + id);
		}
		//employeeRepo.restoreEmployee(id);
		emp.setDeleted(false);
		employeeRepo.save(emp);
		
	}

}
