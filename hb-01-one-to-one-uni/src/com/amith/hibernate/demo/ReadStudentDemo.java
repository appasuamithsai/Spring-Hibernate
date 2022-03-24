package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            System.out.println("creating new Student ....");
            Student student=new Student("Amith","Sai","amithsai@gmail.com");
            session.beginTransaction();
            session.save(student);
            System.out.println(student.getId());


            Student student1=session.get(Student.class,student.getId());
            System.out.println(student1);
            session.getTransaction().commit();
            System.out.println("Done!!");


        }finally {
            factory.close();
        }
    }
}
