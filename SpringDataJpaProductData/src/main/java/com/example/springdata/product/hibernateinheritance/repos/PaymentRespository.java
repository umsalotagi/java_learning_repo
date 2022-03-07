package com.example.springdata.product.hibernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.springdata.product.hibernateinheritance.entity.Payment;

public interface PaymentRespository extends CrudRepository<Payment, Integer> {

}
