package com.precisely.services.services;

import java.util.List;

import com.precisely.services.model.Employee;

public interface EmpService {
	
	public void createEmployee(Employee employee); //CREATE
	public List<Employee> getEmployees(); //READ ALL EMPLOYEES
	public Employee getEmpByID(long id); //SEARCH FOR SPECIFIC EMPLOYEE
	public List<Employee> getEmpByLoc(String loc); //SEARCHES FOR EMPLOYEES BY LOCATION
	public void updateEmployee(Employee employee);	//UPDATE EMPLOYEE DETAILS BY ID
	public void deleteEmployee(long id); //DELETE BY EMPLOYEE ID
}
