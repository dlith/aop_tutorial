package com.dzmitry.aopdemo.aspect;

import com.dzmitry.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("beforeAddAccountAdvice");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            System.out.println("Arg value: " + arg);
            if(arg instanceof Account){
                Account account = (Account) arg;
                System.out.println("Name: " + account.getName());
                System.out.println("ServiceLevel: " + account.getLevel());
            }
        }

        System.out.println("methodSignature: " + methodSignature);
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
