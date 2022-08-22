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
}
