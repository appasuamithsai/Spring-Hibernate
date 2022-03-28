package com.amith.aopdemo.dao;

import com.amith.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account,boolean vipFLag){
        System.out.println(getClass()+" : Doing MY DB Work");
    }

    public void doWork(){
        System.out.println(getClass()+" : Doing MY  Work");
    }


}
