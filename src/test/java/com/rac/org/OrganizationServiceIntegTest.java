package com.rac.org;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = {
		"spring.h2.console.enabled=true" })
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrganizationServiceIntegTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void getEmployeeByProjectCode() throws Exception {
		ResultActions responseEntity = mockMvc.perform(
				MockMvcRequestBuilders.get("/employee/project/{projectId}/department/{departmenId}", "P1001", "D101"));
		assertEquals(HttpStatus.OK.value(), responseEntity.andReturn().getResponse().getStatus());
	}

	@Test
	@Order(2)
	public void getEmployeeByInvalidProjectCode() throws Exception {
		ResultActions responseEntity = mockMvc.perform(
				MockMvcRequestBuilders.get("/employee/project/{projectId}/department/{departmenId}", "P1001", "D102"));
		assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.andReturn().getResponse().getStatus());
		assertEquals("Employee not found with given projectId=P1001 and departmentId=D102",
				responseEntity.andReturn().getResponse().getContentAsString());
	}

	@Test
	@Order(3)
	public void detactEmployeeByProjectCode() throws Exception {
		ResultActions responseEntity = mockMvc.perform(MockMvcRequestBuilders.delete(
				"/projectDepartment/employee/{employeeId}/project/{projectId}/department/{departmenId}", "E10001",
				"P1001", "D101"));
		assertEquals(HttpStatus.OK.value(), responseEntity.andReturn().getResponse().getStatus());
	}

	@Test
	@Order(4)
	public void detactEmployeeByInvalidProjectCode() throws Exception {
		ResultActions responseEntity = mockMvc.perform(MockMvcRequestBuilders.delete(
				"/projectDepartment/employee/{employeeId}/project/{projectId}/department/{departmenId}", "E10002",
				"P1001", "D101"));
		assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.andReturn().getResponse().getStatus());
		assertEquals("Employee not found with given projectId=P1001 and departmentId=D101",
				responseEntity.andReturn().getResponse().getContentAsString());
	}
}
