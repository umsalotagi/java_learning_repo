package com.example.associations.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.associations.onetoone.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
