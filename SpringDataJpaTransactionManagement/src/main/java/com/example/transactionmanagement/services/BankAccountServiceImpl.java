package com.example.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactionmanagement.entities.BankAccount;
import com.example.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountRepository bankAccountRepository;

	@Override
	@Transactional // transactional from org.springframework
	public void transfer(int amount) {
		// Optional.get will throw NoSuchElementException if element is not found
		BankAccount obamasAccount = bankAccountRepository.findById(1).get();
		obamasAccount.setBalance(obamasAccount.getBalance()  - amount);
		bankAccountRepository.save(obamasAccount);
		
		if(true)
			throw new RuntimeException();
		
		BankAccount trumpsAccount = bankAccountRepository.findById(2).get();
		trumpsAccount.setBalance(trumpsAccount.getBalance() + amount);
		bankAccountRepository.save(trumpsAccount);
	}

}
