package com.example.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.transactionmanagement.services.BankAccountService;

@SpringBootTest
class SpringDataJpaTransactionManagementApplicationTests {
	
	@Autowired
	BankAccountService bankService;

	@Test
	void testTransfer() {
		bankService.transfer(500);
	}

}
