package org.tc.employeeportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.employeeportal.dto.EmployeeDto;
import org.tc.employeeportal.dto.LoginDto;
import org.tc.employeeportal.model.Login;
import org.tc.employeeportal.repository.LoginRepository;
import org.tc.employeeportal.util.MapperUtil;


@Service
public class LoginService {

	
	@Autowired LoginRepository repository;
	
	public EmployeeDto login(LoginDto loginDto) {
		EmployeeDto dto=new EmployeeDto();
		Login loginDetails=repository.getEmployeeInformation(loginDto.getUserName(),loginDto.getPassword());
		if(loginDetails!=null) {
			dto=MapperUtil.map(loginDetails.getEmployee(),EmployeeDto.class);
		}
		return dto;
	}
}
