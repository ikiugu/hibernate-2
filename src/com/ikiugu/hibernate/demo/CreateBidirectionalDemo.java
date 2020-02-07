package com.ikiugu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ikiugu.hibernate.demo.entity.Instructor;
import com.ikiugu.hibernate.demo.entity.InstructorDetail;

public class CreateBidirectionalDemo {

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
			// create the objects
			Instructor instructor =  new Instructor("Alfy", "me", "me@gmail.com");
			
			InstructorDetail detail = new InstructorDetail("linx to youtube", "eating");
			
			instructor.setInstructorDetail(detail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the object
			session.save(instructor); // this one line will save both instructor and the instructordetail
			
			//commit a transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}
	
}
