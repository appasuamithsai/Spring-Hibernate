package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Course;
import com.amith.hibernate.demo.entity.Instructor;
import com.amith.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{

            Instructor instructor=new Instructor("Charan","sai","charan@gmail.com");
            InstructorDetail instructorDetail=new InstructorDetail("Youtube.com/cherrygamer", "Love games");

            session.beginTransaction();
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
