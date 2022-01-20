package com.precisely.services.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.precisely.services.repository.*;
import com.precisely.services.model.Employee;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository empRepository;
	public EmpServiceImpl() {
		
	}
	
	@Override
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		for( Employee e :empRepository.findAll()) {
			employees.add(e);
		}
		return employees;
	}
	
	
	@Override
	public Employee getEmpByID(long id) {
			 return empRepository.findById(id).get();
		 }
	
	@Override
	public List<Employee> getEmpByLoc(String loc) {
		return empRepository.findByLocation(loc);
	}
	
	@Override
	public void createEmployee(Employee emp) {
		if(emp!=null) {
			empRepository.save(emp);
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		empRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		empRepository.deleteById(id);
	}

	

	
}
