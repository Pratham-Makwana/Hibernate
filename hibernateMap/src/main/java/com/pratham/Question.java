package com.pratham;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questinId;

	private String question;

	@OneToMany(mappedBy = "question")
	private List<Answer> answer;

	public Question() {

	}

	public Question(int qustionId, String question, List<Answer> answer) {
		this.questinId = qustionId;
		this.question = question;
		this.answer = answer;
	}

	public void setQuestionId(int questionId) {
		this.questinId = questionId;
	}

	public int getQuestionId() {
		return questinId;
	}

	public void setQustion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;

	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

}
