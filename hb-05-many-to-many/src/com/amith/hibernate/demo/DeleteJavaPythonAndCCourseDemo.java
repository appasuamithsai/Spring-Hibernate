package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteJavaPythonAndCCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{

            session.beginTransaction();

            int courseId=12;
            Course course=session.get(Course.class,courseId);
            System.out.println();
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
