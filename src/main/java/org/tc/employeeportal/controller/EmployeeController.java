package org.tc.employeeportal.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tc.employeeportal.dto.EmployeeDto;
import org.tc.employeeportal.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	static final Logger log =LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService service;
	
	@GetMapping
	@ResponseBody
	public List<EmployeeDto> getList() {
		List<EmployeeDto> list = service.findAll();		
		return list;
	}

	@PostMapping
	@ResponseBody
	public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeModel) {
		EmployeeDto employee = service.save(employeeModel);
		log.info("Employee Controller::Add Employee method:Post,response:"+employee.toString());
		return employee;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public EmployeeDto getById(@PathVariable(value = "id") Long id) {
		EmployeeDto employeeModel = service.findById(id);
     
		return employeeModel;
	}

	@PutMapping
	@ResponseBody
	public EmployeeDto empDetailsUpdate(@RequestBody EmployeeDto employeeModel) {
		EmployeeDto updateData = service.update(employeeModel);
		log.info("Employee Controller::Update Employee Details method:Post,response");
		return updateData;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> deleteEmployee(@PathVariable(value = "id") Long id) {
		Map<String, Object> responseMap = service.deleteEmployee(id);
		return responseMap;
	}
}
