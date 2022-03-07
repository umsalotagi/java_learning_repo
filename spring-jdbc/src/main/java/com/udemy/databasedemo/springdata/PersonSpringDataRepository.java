package com.udemy.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.databasedemo.entity.Person;

// with this extend of interface all duplicate functions are auto created. 
// such ad save, findById, deleteById
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

}
