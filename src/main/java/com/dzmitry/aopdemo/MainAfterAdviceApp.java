package com.dzmitry.aopdemo;

import com.dzmitry.aopdemo.config.DemoConfig;
import com.dzmitry.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAfterAdviceApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        try {
            System.out.println(accountDAO.getAccess(false));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(accountDAO.getAccess(true));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        context.close();
    }
}
