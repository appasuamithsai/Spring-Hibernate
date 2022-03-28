package com.amith.aopdemo.dao;

import com.amith.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;
    public void addAccount(Account account,boolean vipFLag){
        System.out.println(getClass()+" : Doing MY DB Work");
    }

    public void doWork(){
        System.out.println(getClass()+" : Doing MY  Work");
    }

    public String getName() {
        System.out.println(getClass()+" : get Name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" : set Name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" : get Service");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" : set Service");
        this.serviceCode = serviceCode;
    }
}
