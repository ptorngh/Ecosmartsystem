package com.example.Ecosmartsystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class EcosmartsystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TransactionRepository transactionRepository;

	@Test
	void addTransactionTest() {
	transactionRepository.addTransaction(new Transaction(Category.TEST, 3000, 20210110));

		Assertions.assertEquals(3000, transactionRepository.totalPerCategory(Category.TEST));
	}
}


