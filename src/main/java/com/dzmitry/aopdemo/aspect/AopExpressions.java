package com.dzmitry.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.dzmitry.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}
    @Pointcut("execution(* com.dzmitry.aopdemo.dao.*.set*(..))")
    public void forSetter(){}
    @Pointcut("execution(* com.dzmitry.aopdemo.dao.*.get*(..))")
    public void forGetter(){}
    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNotGetterSetter(){}

    @Pointcut("execution(* findAccounts())")
    public void forFindAccount(){}
}
