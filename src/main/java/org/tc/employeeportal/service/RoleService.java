package org.tc.employeeportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.employeeportal.dto.RoleDto;
import org.tc.employeeportal.exception.ResourceNotFoundException;
import org.tc.employeeportal.model.Role;
import org.tc.employeeportal.repository.RoleRepository;
import org.tc.employeeportal.util.MapperUtil;

@Service
public class RoleService {

	@Autowired
	RoleRepository repository;

	public List<RoleDto> findAll() {
		List<Role> roleList = repository.findAll();
		System.out.println("Role id "+roleList.get(0));
		List<RoleDto> dtoList = MapperUtil.map(roleList, RoleDto.class);
		return dtoList;
	}

	public RoleDto save(RoleDto roleModel) {
		// TODO Auto-generated method stub
		Role role = MapperUtil.map(roleModel, Role.class);
//		role.setCreatedOn(new Date());
//		role.setStatus("Active");
		role = repository.save(role);
		roleModel = MapperUtil.map(role, RoleDto.class);
		return roleModel;
	}

	public RoleDto findById(Long id) {
		// TODO Auto-generated method stub
		Role role = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role id not found"));
		RoleDto roleDto = MapperUtil.map(role, RoleDto.class);
		return roleDto;
	}

	public RoleDto update(RoleDto roleModel) {
		// TODO Auto-generated method stub
		Role role = MapperUtil.map(roleModel, Role.class);
		role = repository.save(role);
		roleModel = MapperUtil.map(role, RoleDto.class);
		return roleModel;
	}

	public Map<String, Object> deleteRole(Long id) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("response", "Successfully Deleted Record");
		Role model = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found:"));
		model = repository.save(model);
		return responseMap;
	}
	
//	public List<RoleDto> login(String userName,String password,String mobileNo) {
//		List<Role> models=repository.getRoleInformation(userName, password,mobileNo);
//		List<RoleDto> dtoList= MapperUtil.map(models, RoleDto.class);
//		return  dtoList;
//	}
}
