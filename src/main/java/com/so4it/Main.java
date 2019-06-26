package com.so4it;

import com.so4it.service.ServiceFactory;

import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) {

        try {
            ServiceFactory serviceFactory = (ServiceFactory) Class.forName(args[0]).getDeclaredConstructor().newInstance();
            System.out.println(serviceFactory.createAccountService().getBalance(12L));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
