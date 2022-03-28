package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.Course;
import com.amith.hibernate.demo.entity.Instructor;
import com.amith.hibernate.demo.entity.InstructorDetail;
import com.amith.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{

            session.beginTransaction();
            int id=10;
            Course course=session.get(Course.class,id);
            System.out.println(course);
            course.getReviews().forEach(review -> System.out.println(review));
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
