package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            System.out.println("creating new Students ....");
            Student student1=new Student("Ajith","Sai","ajith@gmail.com");
            Student student2=new Student("Charan","Sai","charan@gmail.com");
            Student student3=new Student("Ashwith","Sai","mani@gmail.com");
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            factory.close();
        }
    }
}
