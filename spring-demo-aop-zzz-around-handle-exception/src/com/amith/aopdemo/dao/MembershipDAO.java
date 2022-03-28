package com.amith.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyMember(){
        System.out.println(getClass()+" : Adding a Membership Account");
        return true;
    }

    public void goToSleep(){
        System.out.println(getClass()+" : I am Going to sleep");
    }

}
