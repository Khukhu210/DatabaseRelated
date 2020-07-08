package com.jpa.hibernate.hibernatePractice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Student {
	
	 @Id
	 @GeneratedValue
     private Long id ;
	 
	 @Column(nullable = false)
	 private String name;
	 
	 @OneToOne(fetch = FetchType.LAZY)
	 private Passport passport;
	 
	 //joinColumn - STUDENT_ID
	 //inverseJoinColummn-COURSE_ID
	 @ManyToMany
	 @JoinTable(name = "STUDENT_COURSE",joinColumns = @JoinColumn(name = "STUDENT_ID"),
	 inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	
	 
	  private List<Course> courses = new  ArrayList<>();
	   
	   public Student() {
	 }
	   
	public Student(String name) {
	
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	   
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		this.courses.add(course);
	}

	public String getId() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	
	
	
}
