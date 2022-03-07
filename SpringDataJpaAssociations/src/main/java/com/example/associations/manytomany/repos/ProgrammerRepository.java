package com.example.associations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.associations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
