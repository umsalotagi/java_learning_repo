package com.example.springdata.product.compositekey.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.springdata.product.compositekey.entities.Customer;
import com.example.springdata.product.compositekey.entities.CustomerId;

// here id type is key class
public interface CustomerRepo extends CrudRepository<Customer, CustomerId> {

}
