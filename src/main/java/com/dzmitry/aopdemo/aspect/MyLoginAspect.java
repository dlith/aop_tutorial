package com.dzmitry.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoginAspect {

    @Pointcut("execution(* com.dzmitry.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}
    @Pointcut("execution(* com.dzmitry.aopdemo.dao.*.set*(..))")
    private void forSetter(){}
    @Pointcut("execution(* com.dzmitry.aopdemo.dao.*.get*(..))")
    private void forGetter(){}
    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    private void forDaoPackageNotGetterSetter(){}

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.dzmitry.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.dzmitry.aopdemo.Account))")
    //@Before("execution(* add*(com.dzmitry.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* com.dzmitry.aopdemo.dao.*.*(..))")
    @Before("forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("beforeAddAccountAdvice");
    }

    @Before("forDaoPackageNotGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("performApiAnalytics");
    }

}
