package com.example.Ecosmartsystem;


import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.Assert;


@SpringBootTest
class EcosmartsystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void addTransactionTest() {

		Assert.assertEquals(19, Methods.addTransaction(new int[] {4, 11, 15}, false)); // 4+15

		Assert.

	}

	}

	public Transaction addTransaction(Transaction transaction) {
		transactionList.add(0,transaction);
		return transaction;
}
