package com.dzmitry.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoginAspect {

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.dzmitry.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("beforeAddAccountAdvice");
    }
}
