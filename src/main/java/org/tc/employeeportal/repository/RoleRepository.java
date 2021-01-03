package org.tc.employeeportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tc.employeeportal.model.EmployeeModel;
import org.tc.employeeportal.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
