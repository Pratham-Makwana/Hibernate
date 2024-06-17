package com.d.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project statring");
		// Both The Method is Same
		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();
		Configuration cfg = new Configuration();
		cfg.configure("NewFile.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student
		Student student = new Student();

		student.setId(102);
		student.setName("Ankit");
		student.setCity("Delhi");
		System.out.println(student);

		student.setId(104);
		student.setName("Karan");
		student.setCity("Kanpur");
		System.out.println(student);

		// creating object of address class
		Address address = new Address();
		address.setStreet("Street1");
		address.setCity("Delhi");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(123.4);

		// Reading image

		FileInputStream file = new FileInputStream("src/main/java/profile.jpg");
		byte[] data = new byte[file.available()];
		file.read(data);
		address.setImage(data);
		// Crating the new session
		Session session = factory.openSession();

		// begin the transaction
		Transaction tx = session.beginTransaction();

		// save the object
		session.save(student);
		session.save(address);

		// commit transaction for changes see into database
		tx.commit();
		// closing the session
		session.close();

		System.out.println("Done");
	}
}
