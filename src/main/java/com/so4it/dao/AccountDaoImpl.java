package com.so4it.dao;



import com.so4it.domain.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class AccountDaoImpl implements AccountDao {
    private Map<Long, Account> accounts = new HashMap<>();


    @Override
    public void create(Account account) {
        if(accounts.containsKey(account.getId()))
            throw new RuntimeException("There is a similar account Id number");
        accounts.put(account.getId(),account);
    }


    @Override
    public Optional<Account> read(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    @Override
    public Map<Long,Account> getAccounts(){
        return accounts;
    }

    @Override
    public Collection<Account> readAccountsWithLimit(Double limit) {
        return accounts.values().stream()
                .filter(account -> account.getBalance() > limit)
                .collect(Collectors.toSet());
    }
}
