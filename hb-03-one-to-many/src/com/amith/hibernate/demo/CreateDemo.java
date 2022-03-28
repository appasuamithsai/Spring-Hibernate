package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Instructor;
import com.amith.hibernate.demo.entity.InstructorDetail;
import com.amith.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
//            Instructor instructor=new Instructor("Amith","sai","amithsai@gmail.com");
//            InstructorDetail instructorDetail=new InstructorDetail("Youtube.com/amithtechi", "Love Techi");

            Instructor instructor=new Instructor("Ajith","kumar","ajith@gmail.com");
            InstructorDetail instructorDetail=new InstructorDetail("Youtube.com/ajithfoodie", "Love food");

            session.beginTransaction();
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            factory.close();
        }
    }
}
