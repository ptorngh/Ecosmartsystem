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
	Transaction transactionTest = new Transaction();

		Assertions.assertEquals(transactionTest.getDate(), transactionRepository.addTransaction(new Transaction(Category.RESIDENCE, 3000, 20210110)));
	}
}


