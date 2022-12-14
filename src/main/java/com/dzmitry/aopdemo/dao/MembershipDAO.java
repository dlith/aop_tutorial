package com.dzmitry.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember(){
        System.out.println(getClass() + ": Doing by mb work: adding a membership account");
        return true;
    }

    public void goToSleep(){
        System.out.println(getClass() + ": i am going to sleep");
    }

    public String getFortune() {
        System.out.println(getClass() + ": You have a fortune!");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "You have a fortune!!!";
    }

    public String getFortune(boolean isFortune) {

        if (!isFortune){
            throw new RuntimeException("Major accident! HighWay is closed!");
        }

        System.out.println(getClass() + ": You have a fortune!");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return getFortune();
    }
}
