package com.ikiugu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ikiugu.hibernate.demo.entity.Instructor;
import com.ikiugu.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// create a factory
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//get instructor with id
			Instructor instructor = session.get(Instructor.class, 1);
			
			//delete the instructor
			if (instructor != null) {
				session.delete(instructor);
			}
			
			//commit a transaction
			session.getTransaction().commit();
			
		} catch(Exception e){
			System.out.println("Exception thrown: " + e.getMessage());
		} finally {
			factory.close();
		}
	}
	
}
