package com.sapna.Employee.Management.System.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("/")
	public String health() {
		return "Employee Management API is Up and Running";
	}

}
