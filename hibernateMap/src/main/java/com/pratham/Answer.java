package com.pratham;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;

	@ManyToOne
	private Question question;

	public Answer() {

	}

	public Answer(int answerId, String answer) {
		this.answerId = answerId;
		this.answer = answer;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Question getQuestion() {
		return question;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

}
