package com.rac.org.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rac.org.exception.EmployeeNotFoundException;
import com.rac.org.model.Employee;
import com.rac.org.service.OrganisationService;

@RestController
@RequestMapping("/projectDepartment")
public class ProjectDepartmenController {
	@Autowired
	OrganisationService organisationService;

	@DeleteMapping("employee/{employeeId}/project/{projectId}/department/{departmenId}")
	@Transactional
	public ResponseEntity<List<Employee>> getEmployeeByProjectId(@PathVariable("employeeId") String employeeId,
			@PathVariable("projectId") String projectId, @PathVariable("departmenId") String departmentId) {
		int success = organisationService.detactEmployeefromProjectCode(employeeId, projectId, departmentId);
		if (success != 1) {
			throw new EmployeeNotFoundException(
					"Employee not found with given projectId=" + projectId + " and departmentId=" + departmentId);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
