package org.tc.employeeportal.dto;

import org.tc.employeeportal.model.EmployeeModel;

public class LoginDto {

	
	
	private Long id ;
	private String userName;
	private String password;
	private EmployeeDto employee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "LoginDto [id=" + id + ", userName=" + userName + ", password=" + password + ", employee=" + employee
				+ "]";
	}
	
	
	
}
