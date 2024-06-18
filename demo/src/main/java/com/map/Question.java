package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questinId;
	
	private String question;

	@OneToOne
	@JoinColumn(name = "a_id")
	private Answer answer;
	
	
	public Question() {
		
	}
	
	
	public Question(int qustionId, String question,Answer answer) {
		this.questinId = qustionId;
		this.question = question;
		this.answer = answer;
	}

	public void setQuestionId(int questionId) {
		this.questinId = questionId;
	}

	public int getQuestion() {
		return questinId;
	}

	public void setQustion(String question) {
		this.question = question;
	}

	public String question() {
		return question;

	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Answer getAnswer() {
		return answer;
	}

}
