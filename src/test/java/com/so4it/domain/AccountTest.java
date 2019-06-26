package com.so4it.domain;


import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void accountTest(){
        Account account = new Account.Builder().withId(11L).withBalance(15200d).build();
        Assert.assertNull(account.getName());
        Assert.assertEquals(Double.valueOf(15200d),account.getBalance());
        Assert.assertEquals(Long.valueOf(11L),account.getId());
    }

}