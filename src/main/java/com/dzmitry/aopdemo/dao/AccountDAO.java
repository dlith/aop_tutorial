package com.dzmitry.aopdemo.dao;

import com.dzmitry.aopdemo.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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

    public String getName() {
        System.out.println(getClass() + ": getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode");
        this.serviceCode = serviceCode;
    }
}
