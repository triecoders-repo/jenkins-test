package org.tc.employeeportal.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.employeeportal.dto.EmployeeDto;
import org.tc.employeeportal.exception.ResourceNotFoundException;
import org.tc.employeeportal.model.EmployeeModel;
import org.tc.employeeportal.repository.EmployeeRepository;
import org.tc.employeeportal.util.MapperUtil;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<EmployeeDto> findAll() {
		List<EmployeeModel> employeeList = repository.findAll();
		List<EmployeeDto> dtoList = MapperUtil.map(employeeList, EmployeeDto.class);
		return dtoList;
	}

	public EmployeeDto save(EmployeeDto employeeModel) {
		// TODO Auto-generated method stub
		EmployeeModel employee = MapperUtil.map(employeeModel, EmployeeModel.class);
		employee.setCreatedOn(new Date());
		employee.setStatus("Active");
		employee = repository.save(employee);
		employeeModel = MapperUtil.map(employee, EmployeeDto.class);
		return employeeModel;
	}

	public EmployeeDto findById(Long id) {
		// TODO Auto-generated method stub
		EmployeeModel employee = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee id not found"));
		EmployeeDto employeeDto = MapperUtil.map(employee, EmployeeDto.class);
		return employeeDto;
	}

	public EmployeeDto update(EmployeeDto employeeModel) {
		// TODO Auto-generated method stub
		EmployeeModel employee = MapperUtil.map(employeeModel, EmployeeModel.class);
		employee = repository.save(employee);
		employeeModel = MapperUtil.map(employee, EmployeeDto.class);
		return employeeModel;
	}

	public Map<String, Object> deleteEmployee(Long id) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("response", "Successfully Deleted Record");
		EmployeeModel model = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found:"));
		model.setStatus("InActive");
		model = repository.save(model);
		return responseMap;
	}
	
	public List<EmployeeDto> login(String userName,String password,String mobileNo) {
		List<EmployeeModel> models=repository.getEmployeeInformation(userName, password,mobileNo);
		List<EmployeeDto> dtoList= MapperUtil.map(models, EmployeeDto.class);
		return  dtoList;
	}
}
