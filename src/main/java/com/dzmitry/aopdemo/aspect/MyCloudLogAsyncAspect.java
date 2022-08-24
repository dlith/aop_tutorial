package com.dzmitry.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(20)
public class MyCloudLogAsyncAspect {

    @Before("AopExpressions.forDaoPackageNotGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("logToCloudAsync");
    }
}
