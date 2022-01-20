package com.precisely.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.precisely.services.model.Employee;
import com.precisely.services.services.EmpService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path="/employees")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@Operation(summary = "Read all Employees API")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode="200",
					description="Successful",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=Employee.class))}),
			@ApiResponse(
					responseCode="400",
					description="Error in the request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class))}),					
			@ApiResponse(
					responseCode="404",
					description="Not Found",
					content= @Content),
			@ApiResponse(
					responseCode="500",
					description="Error executing request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class)) })})
		@GetMapping(path="/listAll", produces= {MediaType.APPLICATION_JSON_VALUE})
		public List<Employee> getEmployees() {
		return empService.getEmployees();
	}
	
	@Operation(summary = "Read Employee by ID API")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode="200",
					description="Successful",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=Employee.class))}),
			@ApiResponse(
					responseCode="400",
					description="Error in the request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class))}),					
			@ApiResponse(
					responseCode="404",
					description="Not Found",
					content= @Content),
			@ApiResponse(
					responseCode="500",
					description="Error executing request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class)) })})
		@GetMapping(path="/searchByid", produces= {MediaType.APPLICATION_JSON_VALUE})
		public Employee getEmpByID(@RequestParam("empid") long empid) {
		return empService.getEmpByID(empid);
	}
	
	@Operation(summary = "Read Employees by location API")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode="200",
					description="Successful",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=Employee.class))}),
			@ApiResponse(
					responseCode="400",
					description="Error in the request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class))}),					
			@ApiResponse(
					responseCode="404",
					description="Not Found",
					content= @Content),
			@ApiResponse(
					responseCode="500",
					description="Error executing request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class)) })})
		@GetMapping(path="/searchByLoc", produces= {MediaType.APPLICATION_JSON_VALUE})
		public List<Employee> getEmpByID(@RequestParam("location") String location) {
		return empService.getEmpByLoc(location);
	}
	
	@Operation(summary = "Create Employee info API")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode="200",
					description="Successful",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=Employee.class))}),
			@ApiResponse(
					responseCode="400",
					description="Error in the request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class))}),					
			@ApiResponse(
					responseCode="404",
					description="Not Found",
					content= @Content),
			@ApiResponse(
					responseCode="500",
					description="Error executing request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class)) })})
		@PostMapping(path="/createNew", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,MediaType.TEXT_XML_VALUE})
		public void createEmployee(@RequestBody Employee employee) {
			if(employee != null) {
				empService.createEmployee(employee);
			}
	}
	
	@Operation(summary = "Update Employee info API")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode="200",
					description="Successful",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=Employee.class))}),
			@ApiResponse(
					responseCode="400",
					description="Error in the request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class))}),					
			@ApiResponse(
					responseCode="404",
					description="Not Found",
					content= @Content),
			@ApiResponse(
					responseCode="500",
					description="Error executing request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class)) })})
		@PutMapping(path="/update", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public void updateEmployee(@RequestBody Employee employee) {
			if(employee != null) {
				empService.updateEmployee(employee);
			}
	}
	
	@Operation(summary = "Delete Employee by ID")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode="200",
					description="Successful",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=Employee.class))}),
			@ApiResponse(
					responseCode="400",
					description="Error in the request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class))}),					
			@ApiResponse(
					responseCode="404",
					description="Not Found",
					content= @Content),
			@ApiResponse(
					responseCode="500",
					description="Error executing request",
					content= {@Content(mediaType="application/json", schema =@Schema(implementation=String.class)) })})
		@DeleteMapping(path="/delete", produces= {MediaType.APPLICATION_JSON_VALUE})
		public void deleteEmployee(@RequestParam("empid") long empid) {
				empService.deleteEmployee(empid);
			
	}
	
}
