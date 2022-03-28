package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Instructor;
import com.amith.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{

            session.beginTransaction();
            int id=2;
            Instructor instructor=session.get(Instructor.class,id);
            System.out.println("Deleting "+instructor);
            session.delete(instructor);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            factory.close();
        }
    }
}
