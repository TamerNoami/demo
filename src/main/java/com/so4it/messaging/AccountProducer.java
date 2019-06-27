package com.so4it.messaging;

import com.so4it.domain.Account;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class AccountProducer implements Runnable{

    Random random = new Random(100);

    private BlockingDeque<Account> queue ;

    public AccountProducer(BlockingDeque<Account> queue) {
        this.queue = queue;
    }

    public void create(Account account){
        queue.add(account);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                queue.add(Account.builder().withId(random.nextLong()).withBalance(random.nextDouble()).build());
                System.out.println("Account created at => " + LocalTime.now());
                Thread.sleep(100L);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
