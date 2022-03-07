package com.example.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
