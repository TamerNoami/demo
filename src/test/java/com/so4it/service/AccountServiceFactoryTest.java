package com.so4it.service;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class AccountServiceFactoryTest {

    @Test
    public void createAccountService() throws Exception{
        getBalanceDynamicly("com.so4it.service.ServiceFactoryImplOne").getBalance(1L);
        getBalanceDynamicly("com.so4it.service.ServiceFactoryImplTwo").getBalance(1L);
    }

    public AccountService getBalanceDynamicly(String classs) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ServiceFactory serviceFactory = (ServiceFactory)Class.forName(classs).getDeclaredConstructor().newInstance();
        return serviceFactory.createAccountService() ;
    }
}