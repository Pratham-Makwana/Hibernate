package com.d.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Project statring");
		// Both The Method is Same
		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();
		Configuration cfg = new Configuration();
		cfg.configure("NewFile.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student = new Student();
		student.setId(102);
		student.setName("Raj");
		student.setCity("Mumbai");
		
		
		System.out.println(student);

		// Crating the new session
		Session session = factory.openSession();

		// begin the transaction
		Transaction tx = session.beginTransaction();

		// save the object
		session.save(student);

		// commit transaction for changes see into database
		tx.commit();
		// closing the session
		session.close();

	}
}
