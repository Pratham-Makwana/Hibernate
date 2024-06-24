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
		Student student2 = new Student();

		student.setId(121);
		student.setName("peter");
		student.setCity("Dellhi");
		student.setCerti(new Certificate("Java using hibernate", "2 Month"));

		student2.setId(131);
		student2.setName("Raj");
		student2.setCity("Vadodra");
		student2.setCerti(new Certificate("Flutter", "2.5 Month"));
		// now student object in transient state

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		session.save(student2);
		// now student object in Persistent State - object is associated with session &
		// database

		//student.setName("John");
		transaction.commit();

		Student student1 = (Student) session.get(Student.class, 121);
		System.out.println(student1.getId() + " " + student1.getName() + " " + student1.getCity());
		System.out.println(student1.getCerti().course);
		System.out.println(student1.getCerti().duration);

		sessionFactory.close();
	}
}
