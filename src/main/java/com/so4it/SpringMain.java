package com.so4it;

import com.so4it.dao.AccountDao;
import com.so4it.dao.AccountDaoImpl;
import com.so4it.domain.Account;
import com.so4it.service.AccountService;
import com.so4it.service.ServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Optional;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new GenericXmlApplicationContext("MySpringMain.xml");
        AccountDao dao = (AccountDao) applicationContext.getBean(AccountDaoImpl.class);

        Optional<Account> account1 = dao.read(22L);
        System.out.println(account1.isPresent());

        dao.create(new Account.Builder().withId(22L).withBalance(22100D).build());
        Optional<Account> account = dao.read(22L);
        System.out.println(account.isPresent());

        AccountService accountService = applicationContext.getBean(AccountService.class);
        System.out.println(accountService.getBalance(22L));

        ServiceFactory serviceFactory = applicationContext.getBean(ServiceFactory.class);
        System.out.println(serviceFactory.createAccountService().getBalance(12L));

    }
}
