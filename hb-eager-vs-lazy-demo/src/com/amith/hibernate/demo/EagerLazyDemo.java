package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Course;
import com.amith.hibernate.demo.entity.Instructor;
import com.amith.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{

            session.beginTransaction();

            int id=1;
            Instructor instructor=session.get(Instructor.class,id);
            System.out.println(instructor);

            instructor.getCourses().forEach(course -> System.out.println(course));
            session.getTransaction().commit();

            session.close();

            instructor.getCourses().forEach(course -> System.out.println(course));
            System.out.println("Done!!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
