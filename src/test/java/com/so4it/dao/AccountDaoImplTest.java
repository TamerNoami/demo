package com.so4it.dao;

import com.so4it.domain.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AccountDaoImplTest {

    AccountDao accountDao;

    @Before
    public void testInit(){
       accountDao = new AccountDaoImpl();
        Account account1 = Account.builder().withId(1L).withBalance(12000D).build();
        Account account2 = Account.builder().withId(2L).withBalance(15000D).build();

        accountDao.create(account1);
        accountDao.create(account2);
    }


    @Test
    public void create() {
        Assert.assertEquals(Double.valueOf(15000D),accountDao.read(2L).get().getBalance());
        Assert.assertEquals(Long.valueOf(1L),accountDao.read(1L).get().getId());
    }

    @Test
    public void read() {

        Assert.assertNotNull(accountDao.read(1L));
        Assert.assertEquals(2,accountDao.getAccounts().size());
        Assert.assertNotNull(accountDao.read(3L));
        try {
            accountDao.read(4L).get();
            Assert.fail("No exception");
        }catch (NoSuchElementException e){}
        Assert.assertEquals(Optional.empty(),accountDao.read(4L));


    }


    @Test
    public void readAccountsWithLimit() {
        Assert.assertEquals(1,accountDao.readAccountsWithLimit(12500D).size());
        Assert.assertNotEquals(2,accountDao.readAccountsWithLimit(13000D).size());
        accountDao.readAccountsWithLimit(11000D).forEach(System.out::println);
        Assert.assertTrue(accountDao.readAccountsWithLimit(15001D).isEmpty());
    }
}