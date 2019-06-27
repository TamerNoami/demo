package com.so4it.service;

import com.so4it.dao.AccountDao;
import com.so4it.dao.AccountDaoImpl;
import com.so4it.domain.Account;
import com.so4it.messaging.AccountProducer;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.Assert.*;

public class AccountServiceImplTest {

    AccountService accountService;
    AccountDao accountDao;

    @Before
    public void testInit(){
        AccountDao accountDao = new AccountDaoImpl();
        accountService = new AccountServiceImpl(accountDao,new AccountProducer(new LinkedBlockingDeque<>()));
        Account account1 = Account.builder().withId(1L).withBalance(12000D).build();
        Account account2 = Account.builder().withId(2L).withBalance(15000D).build();

        accountDao.create(account1);
        accountDao.create(account2);
    }


    @Test
    public void getBalance() {
        assertEquals(Double.valueOf(15000D),accountService.getBalance(2L));
    }
}