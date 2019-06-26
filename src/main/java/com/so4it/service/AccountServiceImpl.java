package com.so4it.service;

import com.so4it.dao.AccountDao;
import com.so4it.domain.Account;

import java.util.Objects;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao ;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = Objects.requireNonNull(accountDao,"AccountDoa can't be null");
    }

    @Override
    public Double getBalance(Long id) {
        System.out.println("Im the first one");
        Optional<Account> account = accountDao.read(id);
        if(account.isPresent())
            return account.get().getBalance();
        return 0.0D;
    }
}
