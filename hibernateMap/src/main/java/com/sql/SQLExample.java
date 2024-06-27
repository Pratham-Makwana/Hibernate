package com.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.objectStates.Student;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernatecfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		// SQL query
		String q = "select * from student";

		NativeQuery query = session.createSQLQuery(q);

		List<Object[]> list = query.list();

		for (Object[] student : list) {
			// it take the field as index
			System.out.println(student[1] + " : " + student[2]);
		}
		session.close();
		factory.close();
	}
}
