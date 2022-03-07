package com.example.associations.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.associations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
