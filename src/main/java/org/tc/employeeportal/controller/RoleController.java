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
import org.tc.employeeportal.dto.RoleDto;
import org.tc.employeeportal.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	
	static final Logger log =LoggerFactory.getLogger(RoleController.class);
	@Autowired
	RoleService service;

	@GetMapping
	@ResponseBody
	public List<RoleDto> findAll() {
		log.info("Role Controller::findAll,method:Get");
		List<RoleDto> list = service.findAll();	
		log.info("Role Controller::findAll, method:Get,,response:"+list.toString());
		return list;
	}

	@PostMapping
	@ResponseBody
	public RoleDto addRole(@RequestBody RoleDto roleModel) {
		log.info("Role Controller::Create Role,method:POST,request"+roleModel.toString());
		RoleDto role = service.save(roleModel);
		log.info("Role Controller::Create Role,method:POST,response:"+role.toString());
		return role;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public RoleDto getById(@PathVariable(value = "id") Long id) {
		log.info("Role Controller::FindById,method:Get ,resquest(path variable)"+id);
		RoleDto roleModel = service.findById(id);
		log.info("Role Controller::FindById ,method:Get ,response:"+roleModel.toString());
		return roleModel;
	}

	@PutMapping
	@ResponseBody
	public RoleDto roleDetailsUpdate(@RequestBody RoleDto roleModel) {
		log.info("Role Controller::Update Role Details method:Put,request:"+roleModel.toString());
		RoleDto updateData = service.update(roleModel);
		log.info("Role Controller::Update Role Details method:Put,response:"+updateData.toString());
		return updateData;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> deleteRole(@PathVariable(value = "id") Long id) {
		log.info("Role Controller::Delete Role Details,method:Delete,request:"+id);
		Map<String, Object> responseMap = service.deleteRole(id);
		log.info("Role Controller::Delete Role Details, method:Delete,response:"+responseMap);
		return responseMap;
	}
}
