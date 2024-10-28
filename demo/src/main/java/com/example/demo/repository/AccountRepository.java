package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccountRepository {
    private final Map<Long, Account> accounts = new HashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1); // Starts ID from 1

    public Account save(Account account) {
        if (account.getAccountId() == null) {
            account.setAccountId(idGenerator.getAndIncrement());
        }
        accounts.put(account.getAccountId(), account);
        return account;
    }

    public Account findById(Long id) {
        return accounts.get(id);
    }

    public Collection<Account> findAll() {
        return accounts.values();
    }

    public void deleteById(Long id) {
        accounts.remove(id);
    }
}
