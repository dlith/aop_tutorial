package com.dzmitry.aopdemo;

import com.dzmitry.aopdemo.config.DemoConfig;
import com.dzmitry.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainAroundHandleExceptionAdviceApp {

    private static Logger logger = Logger.getLogger(MainAroundHandleExceptionAdviceApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        logger.info("Calling fortune");

        String data = membershipDAO.getFortune(false);

        logger.info("My fortune is: " + data);
        logger.info("FINISHED");

        context.close();
    }
}
