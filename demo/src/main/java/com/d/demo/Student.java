package com.d.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String city;
	
	
	public Student (int id,String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public Student() {
		
	}
	
	public String getName() {
		return name;
	}
	 public String getCity() {
		 return city;
		
	 }
	 
	 public int getId() {
		 return id;
	 }

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return id + " : " + name + " : " + city;
	}
}
