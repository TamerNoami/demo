package com.so4it.service;

import com.so4it.dao.AccountDao;
import com.so4it.dao.AccountDaoImpl;
import com.so4it.domain.Account;

public class ServiceFactoryImplOne implements ServiceFactory {
    @Override
    public AccountService createAccountService() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.create(new Account.Builder().withId(12L).withBalance(34500D).build());
        return new AccountServiceImpl(accountDao);
    }
}
