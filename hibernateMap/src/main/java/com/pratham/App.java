package com.pratham;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernatecfg.xml");

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

		Answer answer1 = new Answer();
		answer1.setAnswerId(1002);
		answer1.setAnswer("java is object orieanted Programming language");
		answer1.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setAnswerId(1003);
		answer2.setAnswer("In java every thing is class & object");
		answer2.setQuestion(question);

		List<Answer> list = new ArrayList();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		question.setAnswer(list);

		// session
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// save
		session.save(question);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);

		transaction.commit();
//
//		// fetching
		Question newQ = (Question) session.get(Question.class, 101);
		System.out.println(newQ.getQuestion());
		
		for (Answer ans : newQ.getAnswer()) {
			System.out.println(ans.getAnswer());
		}

		session.close();

		sessionFactory.close();
	}
}
