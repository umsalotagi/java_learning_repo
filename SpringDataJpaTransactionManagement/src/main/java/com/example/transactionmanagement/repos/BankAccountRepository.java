package com.example.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
