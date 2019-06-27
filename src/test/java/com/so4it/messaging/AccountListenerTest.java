package com.so4it.messaging;

import com.so4it.domain.Account;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.Assert.*;

public class AccountListenerTest {

    @Test
    public void testProducerConsumer() throws InterruptedException {
        BlockingDeque<Account> accounts = new LinkedBlockingDeque<>();

        AccountProducer accountProducer = new AccountProducer(accounts);
        //Lambda expression
        AccountConsumer accountConsumer = new AccountConsumer(accounts,System.out::println);

        //Anonymous class
        AccountListener accountListener = new AccountListener() {
            @Override
            public void onAccount(Account account) {
                System.out.println(accounts);
            }
        };
                AccountConsumer accountConsumer1 = new AccountConsumer(accounts,accountListener);

        //Another way of doing lambda
        AccountConsumer accountConsumer2 = new AccountConsumer(accounts,account -> System.out.println(account));

        //Another way of doing lambda
        List<AccountListener> accountListeners = new ArrayList<>();
        accountListeners.add(account -> System.out.println(account));


        new Thread(accountConsumer).start();
        new Thread(accountProducer).start();

        Thread.sleep(4000L);
    }
}
