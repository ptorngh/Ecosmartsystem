package com.example.Ecosmartsystem;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionRepository {

    private List<Transaction> transactionList;

    public TransactionRepository() {
        transactionList = new ArrayList<>();
        transactionList.add(new Transaction(Category.RESIDENCE, 3000, 20210110));
        transactionList.add(new Transaction(Category.PLEASURE, 1000, 20210112));
        transactionList.add(new Transaction(Category.TRANSPORTATION, 1500, 20210113));
        transactionList.add(new Transaction(Category.RESIDENCE, 1000, 20210117));
        transactionList.add(new Transaction(Category.PLEASURE, 500, 20210124));
    }

    // get all transactions
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    // add a transaction
    public Transaction addTransaction(Transaction transaction) {
        transactionList.add(0,transaction);
        return transaction;
    }

    public int totalPerCategory(Category cat) {

        int sum = 0;
        for (Transaction transaction : transactionList) {
            if (cat == transaction.getCategory()) {
                sum = transaction.getAmount() + sum;
            }
        }
        return sum;
    }
}