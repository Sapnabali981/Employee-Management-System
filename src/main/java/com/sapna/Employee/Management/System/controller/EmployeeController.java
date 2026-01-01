package com.sapna.Employee.Management.System.controller;

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

import com.sapna.Employee.Management.System.entity.Employee;
import com.sapna.Employee.Management.System.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeServiceImpl service;
	public EmployeeController(EmployeeServiceImpl service) {
		this.service=service;
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
	//	System.out.println("inside the post method.");
		Employee savedEmployee = service.createEmployee(emp);
	//	System.out.println("Data is saved successfully..");
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		
	}
	 @GetMapping("/fetchAllEmployees")
	 public ResponseEntity<List<Employee>> getAllEmployee(){
		 List<Employee> allEmployee = service.getAllEmployees();
		 return new ResponseEntity<>(allEmployee,HttpStatus.OK);
	 }
	 
	 @GetMapping("/fetchById/{id}")
	 public ResponseEntity<Employee> getById(@PathVariable int id){
		 
		 return ResponseEntity.ok(service.getEmployeeById(id));
		 
		
		
	 }
	 
	 
	 @PutMapping("/updateById/{id}")
	 public ResponseEntity<Employee> update(@RequestBody Employee emp,@PathVariable int id){
		Employee updateEmployee = service.updateEmployee(id, emp);
		
		 return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
		 
	 }
	 
	 @DeleteMapping("/deleteEmployeeById/{id}")
	 public ResponseEntity<String> deleteById(@PathVariable int id) {
	
		 service.deleteEmployee(id);
		 return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
	 }
	 
	 //creating restore API for deleted employee data
	 
	 @PutMapping("/restoreEmployee/{id}")
	 public ResponseEntity<String> restoreEmployee(@PathVariable int id){
		 service.restoreEmployee(id);
		 return new ResponseEntity<>("Employee details is been restored successfully",HttpStatus.CREATED);
		 
	 }
}

