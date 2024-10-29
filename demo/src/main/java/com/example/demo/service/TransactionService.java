package com.example.demo.service;

import com.example.demo.dto.TransactionDTO;
import com.example.demo.model.Account;
import com.example.demo.model.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void processTransaction(TransactionDTO transactionDTO) {
        if (transactionDTO.getFromAccountId() == null || transactionDTO.getToAccountId() == null) {
            throw new IllegalArgumentException("Account IDs cannot be null");
        }
        if (transactionDTO.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        Account fromAccount = accountRepository.findById(transactionDTO.getFromAccountId());
        Account toAccount = accountRepository.findById(transactionDTO.getToAccountId());

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account ID(s)");
        }
        if (fromAccount.getBalance() < transactionDTO.getAmount()) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        fromAccount.setBalance(fromAccount.getBalance() - transactionDTO.getAmount());
        toAccount.setBalance(toAccount.getBalance() + transactionDTO.getAmount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction(
                UUID.randomUUID().toString(),
                transactionDTO.getFromAccountId(),
                transactionDTO.getToAccountId(),
                transactionDTO.getAmount());
        transactionRepository.save(transaction);

        fromAccount.addTransaction(transaction);
        toAccount.addTransaction(transaction);
    }
}
