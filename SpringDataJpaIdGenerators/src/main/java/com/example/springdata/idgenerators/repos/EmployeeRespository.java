package com.example.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.springdata.idgenerators.entities.Employee;

public interface EmployeeRespository extends CrudRepository<Employee, Long> {

}
