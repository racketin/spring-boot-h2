package com.rac.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rac.org.model.EmployeeProjectDepartment;

public interface EmployeeProjectDepartmentRepository extends JpaRepository<EmployeeProjectDepartment, String> {
	public int deleteByemployeeIdAndProjectIdAndDepartmentId(String employeeId, String projectId, String departmentId);
}
