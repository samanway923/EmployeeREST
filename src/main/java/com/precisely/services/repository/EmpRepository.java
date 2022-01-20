package com.precisely.services.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.precisely.services.model.Employee;

@Repository
public interface EmpRepository extends CrudRepository<Employee, Long>{
    List<Employee> findByLocation(@Param(value = "location") String role);

}
