package com.dzmitry.aopdemo.dao;

import com.dzmitry.aopdemo.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;
    private List<Account> accounts;

    public void addAccount() {
        System.out.println(getClass() + ": Doing by mb work: adding an account");
    }

    public void addAccount(Account account){
        if(accounts == null){
            accounts = new ArrayList<>();
        }
        accounts.add(account);
        System.out.println(getClass() + ": " + account);
    }

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": " + account + ", " + vipFlag);
    }

    public void doWork(){
        System.out.println(getClass() + ": Doing work");
    }

    public List<Account> findAccounts(){
        return accounts;
    }

    public String getAccess(boolean isFreeAccess){
        if (!isFreeAccess){
            throw new RuntimeException("You do not have access");
        }
        return "Access allowed";
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
