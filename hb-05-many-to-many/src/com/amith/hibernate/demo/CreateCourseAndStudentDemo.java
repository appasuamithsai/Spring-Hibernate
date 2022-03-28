package com.amith.hibernate.demo;

import com.amith.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
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

            Course course=new Course("Java & Python &c");

            session.save(course);



            Student student1=new Student("AMith","sai","amith@gmail.com");
            Student student2=new Student("Nagesh","Goud","nagesh@gmail.com");
            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);
            System.out.println();


            Course course1=new Course("Data Structure");
            Course course2=new Course("Algorithms");

            course1.addStudent(student1);
            course2.addStudent(student1);
            System.out.println("Saving Courses");

            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }finally {
            session.close();
            factory.close();
        }
    }
}
