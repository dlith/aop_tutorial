package com.dzmitry.aopdemo;

import com.dzmitry.aopdemo.config.DemoConfig;
import com.dzmitry.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAfterReturningAdviceApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        Account account1 = new Account("Name1", "level1");
        Account account2 = new Account("Name2", "level2");

        accountDAO.addAccount(account1);
        accountDAO.addAccount(account2);

        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("=========");
        for(Account account: accounts){
            System.out.println(account);
        }

        context.close();
    }
}


