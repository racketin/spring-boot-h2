package com.rac.org.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rac.org.model.Employee;
import com.rac.org.repository.EmployeeProjectDepartmentRepository;
import com.rac.org.repository.EmployeeRepository;

@Service
public class OrganisationService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeProjectDepartmentRepository employeeProjectDepartmentRepository;

	public Optional<Employee> findEmployeeById(String id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> findByProjectCode(String projectId, String departmentId) {
		return employeeRepository.findByProjectCode(projectId, departmentId);
	}

	public int detactEmployeefromProjectCode(String employeeId, String projectId, String departmentId) {
		return employeeProjectDepartmentRepository.deleteByemployeeIdAndProjectIdAndDepartmentId(employeeId, projectId, departmentId);
	}
}
