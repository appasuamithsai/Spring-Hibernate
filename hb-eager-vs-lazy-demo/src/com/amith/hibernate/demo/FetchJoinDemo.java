package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Course;
import com.amith.hibernate.demo.entity.Instructor;
import com.amith.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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
            Query<Instructor> query=session.createQuery("select i from Instructor i " +
                            "JOIN FETCH i.courses" +
                            " where i.id=:theInstructorId",
                    Instructor.class);
            query.setParameter("theInstructorId",id);
            Instructor instructor=query.getSingleResult();
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
