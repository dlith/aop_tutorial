package com.dzmitry.aopdemo.dao;

import com.dzmitry.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": Doing by mb work: adding an account");
    }

    public void addAccount(Account account){
        System.out.println(getClass() + ": " + account);
    }

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": " + account + ", " + vipFlag);
    }

    public void doWork(){
        System.out.println(getClass() + ": Doing work");
    }
}
