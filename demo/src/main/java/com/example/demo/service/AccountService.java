package com.example.demo.service;

import com.example.demo.dto.AccountDTO;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = new Account(null, accountDTO.getAccountHolderName(), accountDTO.getInitialBalance());
        accountRepository.save(account);
        accountDTO.setAccountId(account.getAccountId());
        return accountDTO;
    }

    public List<Account> getAllAccounts() {
        Collection<Account> accounts = accountRepository.findAll();
        return new ArrayList<Account>(accounts);
    }

}
