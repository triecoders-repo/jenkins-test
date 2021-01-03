package org.tc.employeeportal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.tc.employeeportal.controller.RoleController;
import org.tc.employeeportal.dto.RoleDto;
import org.tc.employeeportal.service.RoleService;

@RunWith(MockitoJUnitRunner.class)
public class RoleControllerTest {

	
	@Mock RoleService service;
	
	
	@InjectMocks RoleController controller;
	
	RoleDto dto;
	
	@Before 
	public void setup() {
		dto=new RoleDto();
		dto.setId(1L);
		dto.setName("Manager");
		
	}
	@Test
	public void getRolesTest() {
		when(service.findById(1L)).thenReturn( dto);
		RoleDto roleDto=controller.getById(1L);
		assertEquals("1",roleDto.getId().toString());
	}
}

