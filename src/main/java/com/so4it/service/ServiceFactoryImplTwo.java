package com.so4it.service;

import com.so4it.dao.AccountDao;
import com.so4it.domain.Account;
import com.so4it.messaging.AccountProducer;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;

public class ServiceFactoryImplTwo implements ServiceFactory {
    @Override
    public AccountService createAccountService() {
        return new AccountServiceImpl(new AccountDaoMock(),new AccountProducer(new LinkedBlockingDeque<>()));
    }

    public static class AccountDaoMock implements AccountDao{

        @Override
        public void create(Account account) {

        }

        @Override
        public Optional<Account> read(Long id) {
            System.out.println("I'm in the second one");
            return Optional.empty();
        }

        @Override
        public Map<Long, Account> getAccounts() {
            return null;
        }

        @Override
        public Collection<Account> readAccountsWithLimit(Double limit) {
            return null;
        }
    }
}
