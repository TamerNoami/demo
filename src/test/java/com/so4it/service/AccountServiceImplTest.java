package com.so4it.service;

import com.so4it.dao.AccountDao;
import com.so4it.dao.AccountDaoImpl;
import com.so4it.domain.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountServiceImplTest {

    AccountService accountService;
    AccountDao accountDao;

    @Before
    public void testInit(){
        AccountDao accountDao = new AccountDaoImpl();
        accountService = new AccountServiceImpl(accountDao);
        Account account1 = new Account.Builder().withId(1L).withBalance(12000D).build();
        Account account2 = new Account.Builder().withId(2L).withBalance(15000D).build();

        accountDao.create(account1);
        accountDao.create(account2);
    }


    @Test
    public void getBalance() {
        assertEquals(Double.valueOf(15000D),accountService.getBalance(2L));
    }
}