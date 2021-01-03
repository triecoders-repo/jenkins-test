package org.tc.employeeportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tc.employeeportal.model.EmployeeModel;
import org.tc.employeeportal.model.Login;

public interface LoginRepository  extends JpaRepository<Login, Long>  {

	@Query("from Login where (userName=:userName  AND password=:password)")
	public Login getEmployeeInformation(@Param("userName")String userName,@Param("password") String password);

}
