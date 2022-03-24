package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            session.beginTransaction();
            List<Student> studentList=session.createQuery("from Student").list();
            studentList.forEach(student -> System.out.println(student));
            System.out.println();
            studentList=session.createQuery("from Student s where s.firstName='amith'").list();
            studentList.forEach(student -> System.out.println(student));
            System.out.println();
            studentList=session.createQuery("from Student s where s.firstName='amith' OR s.lastName='sai'" ).list();
            studentList.forEach(student -> System.out.println(student));
            System.out.println();
            studentList=session.createQuery("from Student s where s.email LIKE '%sai@gmail.com'").list();
            studentList.forEach(student -> System.out.println(student));

            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
