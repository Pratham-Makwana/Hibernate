package com.d.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("NewFile.xml");
		SessionFactory factory =  cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(1161);
		student1.setCity("Delhi");
		student1.setName("Ral");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Android Developer");
		certificate1.setDuration("2 Month");
		
		student1.setCerti(certificate1);
		
		Student student2 = new Student();
		student2.setId(201);
		student2.setCity("Gujarat");
		student2.setName("Ajay");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Fluttter Developer");
		certificate2.setDuration("6 Month");
		
		student2.setCerti(certificate2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		tx.commit();
		session.close();
		factory.close();
	}
}
