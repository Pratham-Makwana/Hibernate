package com.objectStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
	public static void main(String[] args) {

		// Practical of Hibernate Object class;
		// Transient
		// Persistent
		// Detached
		// Removed
		System.out.println("Example: ");
		SessionFactory sessionFactory = new Configuration().configure("hibernatecfg.xml").buildSessionFactory();

		// Creating student object
		Student student = new Student();
		student.setId(121);
		student.setName("peter");
		student.setCity("Dellhi");
		student.setCerti(new Certificate("Java using hibernate", "2 Month"));
		// now student object in transient state

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		// now student object in Persistent State - object is associated with session &
		// database

		student.setName("John");
		transaction.commit();

		Student student1 = (Student) session.get(Student.class, 121);
		System.out.println(student1.getId() + " " + student1.getName() + " " + student1.getCity());
		System.out.println(student1.getCerti().course);
		System.out.println(student1.getCerti().duration);
		
		sessionFactory.close();
	}
}
