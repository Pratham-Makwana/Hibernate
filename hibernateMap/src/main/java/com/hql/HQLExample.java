package com.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.objectStates.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernatecfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// HQL
		// Syntax
		String query = "from Student";
		String query2 = "from Student where city='Delhi'";

		String queryString = "from Student where city=:x";
		String queryString1 = "from Student as s where s.city=:x and s.name=:a";

		Query q = session.createQuery(query);
		Query q2 = session.createQuery(query2);
		Query query1 = session.createQuery(queryString);
		Query querys2 = session.createQuery(queryString1);

		query1.setParameter("x", "Vadodra");
		querys2.setParameter("x", "Vadodra");
		querys2.setParameter("a", "Raj");

		// single (Unique)
		// multiple (List)

		List<Student> list = q.list();
		List<Student> list2 = q2.list();
		List<Student> students = query1.list();
		List<Student> students1 = querys2.list();

		for (Student student : students1) {
			System.out.println(student.getName() + ": " + student.getCerti().getCourse() + " : " + student.getCity());
		}

		System.out.println("______________________________________________________________");

		Transaction tx = session.beginTransaction();

		// Delete Query
		Query d = session.createQuery("delete from Student s where s.city=:c");
		d.setParameter("c", "Delhi");
		int r = d.executeUpdate();
		System.out.println("deleted" + r);

		// Update Query
//		Query uQuery = session.createQuery("update Student set city=:c where name=:n");
//		uQuery.setParameter("c", "Delhi");
//		uQuery.setParameter("n", "peter");
//		int row = uQuery.executeUpdate();
//		System.out.println("Upadate row: " + row);

		tx.commit();

		session.close();
		sessionFactory.close();
	}
}
