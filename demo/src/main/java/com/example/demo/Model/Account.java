package com.example.demo.Model;

import java.util.*;;

public class Account {
    private Long accountId;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() { }

    public Account(Long accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
    
}