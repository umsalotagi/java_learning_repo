package com.example.associations.onetomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.associations.onetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
