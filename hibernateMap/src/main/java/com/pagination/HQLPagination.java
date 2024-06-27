package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.objectStates.Student;

public class HQLPagination {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernatecfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("from Student");

		// implementation of the pagination in hibernate
		query.setFirstResult(0);
		query.setMaxResults(5);

		List<Student> list = query.list();
		
		for (Student student : list) {
			System.out.println(student.getName() + " : " + student.getCity());
		}
		session.close();
		factory.close();
	}
}
