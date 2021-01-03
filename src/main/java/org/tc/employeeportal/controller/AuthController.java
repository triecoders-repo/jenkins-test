package org.tc.employeeportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tc.employeeportal.dto.EmployeeDto;
import org.tc.employeeportal.dto.LoginDto;
import org.tc.employeeportal.service.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired LoginService service;
	
	@PostMapping("/login")
	public EmployeeDto login(@RequestBody LoginDto login) {
		EmployeeDto employeeDto= service.login(login);
		return employeeDto;
	}
}
