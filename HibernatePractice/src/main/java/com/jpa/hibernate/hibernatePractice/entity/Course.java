package com.jpa.hibernate.hibernatePractice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	
	 @Id
	 @GeneratedValue
     private Long id ;
	 private String name;
	   
	   public Course() {
	 }
	   
	public Course(String name) {
	
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	   
	public String getId() {
		return name;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	
}
