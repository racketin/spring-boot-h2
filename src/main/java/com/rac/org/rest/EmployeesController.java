package com.rac.org.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rac.org.exception.EmployeeNotFoundException;
import com.rac.org.model.Employee;
import com.rac.org.service.OrganisationService;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
	@Autowired
	OrganisationService organisationService;

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
		Optional<Employee> employee = organisationService.findEmployeeById(id);
		if (employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/project/{projectId}/department/{departmenId}")
	public ResponseEntity<List<Employee>> getEmployeeByProjectId(@PathVariable("projectId") String projectId,
			@PathVariable("departmenId") String departmentId) {
		List<Employee> employee = organisationService.findByProjectCode(projectId, departmentId);
		if (employee.isEmpty()) {
			throw new EmployeeNotFoundException(
					"Employee not found with given projectId=" + projectId + " and departmentId=" + departmentId);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

}
