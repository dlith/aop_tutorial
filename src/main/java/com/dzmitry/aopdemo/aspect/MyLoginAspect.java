package com.dzmitry.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(30)
public class MyLoginAspect {

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.dzmitry.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.dzmitry.aopdemo.Account))")
    //@Before("execution(* add*(com.dzmitry.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* com.dzmitry.aopdemo.dao.*.*(..))")
    @Before("AopExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("beforeAddAccountAdvice");
    }

    /*@Before("forDaoPackageNotGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("performApiAnalytics");
    }

    @Before("forDaoPackageNotGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("logToCloudAsync");
    }*/

}
