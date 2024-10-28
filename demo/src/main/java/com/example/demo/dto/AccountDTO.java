package com.example.demo.dto;

public class AccountDTO {
    private long accountId;
    private String accountHolderName;
    private double initialBalance;

    public AccountDTO() {
    }

    public AccountDTO(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.initialBalance = initialBalance;
    }

    public long getAccountId(){
        return accountId;
    }

    public void setAccountId(long accountId){
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setBalance(double balance) {
        this.initialBalance = balance;
    }
}

