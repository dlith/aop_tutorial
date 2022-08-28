package com.dzmitry.aopdemo;

import com.dzmitry.aopdemo.config.DemoConfig;
import com.dzmitry.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainAroundWithLoggerAdviceApp {

    private static Logger logger = Logger.getLogger(MainAroundWithLoggerAdviceApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        logger.info("Calling fortune");

        String data = membershipDAO.getFortune();

        logger.info("My fortune is: " + data);
        logger.info("FINISHED");

        context.close();
    }
}
