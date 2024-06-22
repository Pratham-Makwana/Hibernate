package com.objectStates;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

	String course;
	String duration;

	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
