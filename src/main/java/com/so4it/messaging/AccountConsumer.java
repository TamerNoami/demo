package com.so4it.messaging;

import com.so4it.dao.AccountDao;
import com.so4it.domain.Account;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class AccountConsumer implements Runnable{
    private BlockingQueue<Account> accounts ;
    AccountDao accountDao;

    public AccountConsumer(BlockingQueue<Account> queue, AccountDao accountDao) {
        this.accounts = Objects.requireNonNull(queue,"que can't be null");
        this.accountDao = Objects.requireNonNull(accountDao,"accoutDao can't be null");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                accounts.poll(100L, TimeUnit.MILLISECONDS);
                if(accounts!=null){

                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
