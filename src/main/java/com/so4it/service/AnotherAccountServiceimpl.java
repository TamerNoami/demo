package com.so4it.service;

import com.so4it.domain.Account;

public class AnotherAccountServiceimpl implements AccountService {
    @Override
    public Double getBalance(Long id) {
        return 111D;
    }

    @Override
    public void create(Account account) {

    }
}
