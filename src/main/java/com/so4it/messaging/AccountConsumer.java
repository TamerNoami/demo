package com.so4it.messaging;

import com.so4it.domain.Account;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class AccountConsumer implements Runnable{



    private List<AccountListener> accountListeners = new CopyOnWriteArrayList<>();
    private BlockingQueue<Account> accounts ;


    public AccountConsumer(BlockingQueue<Account> queue, AccountListener accountListener) {
        this.accounts = Objects.requireNonNull(queue,"que can't be null");
        accountListeners.add(Objects.requireNonNull(accountListener,"accountListener can't be null"));
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Account account = accounts.poll(120L, TimeUnit.MILLISECONDS);
                if(accounts!=null){
                    System.out.println("Account polled at => " + LocalTime.now());
                    accountListeners.forEach(accountListener -> accountListener.onAccount(account));
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
