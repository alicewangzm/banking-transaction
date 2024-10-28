package com.example.demo.repository;

import com.example.demo.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> findAll() {
        return transactions;
    }
}
