package com.rac.org.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	String id;
	@Column(name = "name")
	String name;
	@OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<EmployeeProjectDepartment> employeeProjectDepartment;

	public List<EmployeeProjectDepartment> getEmployeeProjectDepartment() {
		return employeeProjectDepartment;
	}

	public void setEmployeeProjectDepartment(List<EmployeeProjectDepartment> employeeProjectDepartment) {
		this.employeeProjectDepartment = employeeProjectDepartment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
