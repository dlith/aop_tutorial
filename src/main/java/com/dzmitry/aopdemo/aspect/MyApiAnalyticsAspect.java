package com.dzmitry.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class MyApiAnalyticsAspect {


    @Before("AopExpressions.forDaoPackageNotGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("performApiAnalytics");
    }
}
