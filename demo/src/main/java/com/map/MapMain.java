package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapMain {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("NewFile.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// creating Question
		Question question = new Question();
		question.setQuestionId(101);
		question.setQustion("what is java");

		// creating Answer
		Answer answer = new Answer();
		answer.setAnswerId(1001);
		answer.setAnswer("java is Programming language");
		answer.setQuestion(question);
		question.setAnswer(answer);

		// session
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// save
		session.save(question);
		session.save(answer);

		transaction.commit();

		// fetching
		Question newQ = (Question) session.get(Question.class, 101);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());

		session.close();

		sessionFactory.close();
	}
}
