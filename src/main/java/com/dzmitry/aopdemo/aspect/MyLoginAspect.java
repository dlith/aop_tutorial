package com.dzmitry.aopdemo.aspect;

import com.dzmitry.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @AfterReturning(pointcut = "AopExpressions.forFindAccount()", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("afterReturningFindAccountAdvice");
        System.out.println("methodSignature: " + methodSignature);

        System.out.println("Size:" + result.size());

        for(Account account: result){
            System.out.println(account);
        }

        if(!result.isEmpty()){
            result.get(0).setName("New name from after returning");
        }

    }

    @AfterThrowing(pointcut = "execution(* com.dzmitry.aopdemo.dao.AccountDAO.getAccess(..))", throwing = "error")
    public void afterThrowingDividingAdvice(JoinPoint joinPoint, Throwable error){
        System.out.println("afterThrowingDividingAdvice on method: " + joinPoint.getSignature().toShortString());
        System.out.println("The exception is: " + error);
    }

}
