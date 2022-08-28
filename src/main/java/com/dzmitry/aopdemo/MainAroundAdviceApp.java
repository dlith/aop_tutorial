package com.dzmitry.aopdemo;

import com.dzmitry.aopdemo.config.DemoConfig;
import com.dzmitry.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAroundAdviceApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        String data = membershipDAO.getFortune();

        System.out.println("My fortune is: " + data);

        System.out.println("FINISHED");

        context.close();
    }
}
