package com.d.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FetchDemo {
	public static void main(String[] args) {
		// fetch data using get , load

		Configuration cfg = new Configuration();
		cfg.configure("NewFile.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		// get - student:104
		Student student = (Student) session.get(Student.class, 102);
		System.out.println(student);
		Student student2 = session.load(Student.class, 104);
		System.out.println(student2);

		Address ad =(Address) session.get(Address.class, 1);
		System.out.println(ad.getCity());
		session.close();
		factory.close();
	}
}
