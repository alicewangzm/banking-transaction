package com.example.demo.model;

import java.util.*;;

public class Account {
    private String accountHolderName = "";
    private Long accountId;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() { }

    public Account(Long accountId, String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName = accountHolderName;

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
