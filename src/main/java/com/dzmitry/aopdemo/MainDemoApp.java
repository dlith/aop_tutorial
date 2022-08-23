package com.dzmitry.aopdemo;

import com.dzmitry.aopdemo.config.DemoConfig;
import com.dzmitry.aopdemo.dao.AccountDAO;
import com.dzmitry.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        accountDAO.addAccount(new Account());
        accountDAO.addAccount(new Account(), true);
        accountDAO.doWork();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addMember();
        membershipDAO.goToSleep();

        context.close();
    }
}
