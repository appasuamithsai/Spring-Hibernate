package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            int studentId=8;
             session.beginTransaction();
            Student student=session.get(Student.class,studentId);
            System.out.println("Updating");
            student.setFirstName("AAAA");
            session.getTransaction().commit();

            session=factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='cool@mvsr.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Hurray Updated!!!");


        }finally {
            factory.close();
        }
    }
}
