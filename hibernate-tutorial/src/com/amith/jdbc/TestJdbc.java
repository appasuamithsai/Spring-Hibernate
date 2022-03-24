package com.amith.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?serverTimeZone=UTC";
        String user="hbstudent";
        String password="Hbstudent@123";
        try{
            System.out.println("Connecting ....");
            Connection con= DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println( "Connection Successful!!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
