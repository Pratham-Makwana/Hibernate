package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernatecfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Emp e1 = new Emp();
		Emp e2 = new Emp();

		e1.setId(34);
		e1.setName("Ram");
		e2.setId(37);
		e2.setName("Shyam");

		Project p1 = new Project();
		Project p2 = new Project();

		p1.setProjectId(121);
		p1.setProjectName("Library System");
		
		p2.setProjectId(141);
		p2.setProjectName("ChatBot");
		
		List<Emp> empList = new ArrayList<Emp>();
		List<Project> projectList = new ArrayList<Project>();
		
		empList.add(e1); 
		empList.add(e2);
		
		projectList.add(p1);
		projectList.add(p2);
		
		// 
		e1.setProjects(projectList);
		p2.setEmps(empList);
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
	}
}
