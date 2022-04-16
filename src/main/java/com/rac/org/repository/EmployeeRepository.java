package com.rac.org.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rac.org.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	Optional<Employee> findById(String id);

	List<Employee> findByNameContaining(String name);

	@Query("SELECT emp FROM Employee emp JOIN emp.employeeProjectDepartment empProjectDepart"
			+ " WHERE empProjectDepart.projectId = ?1 and empProjectDepart.departmentId = ?2")
	List<Employee> findByProjectCode(String projectId, String departmentId);
	
}
