package com.jpa.hibernate.hibernatePractice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
		value = {
				@NamedQuery(name="query_get_all_courses",
						query="Select c from Course c"),
				@NamedQuery(name="query_get_100_Steps_courses",
				query="Select c from Course c where name like '%100 Steps'")	
		})


public class Course {
	
	 @Id
	 @GeneratedValue
     private Long id ;
	 private String name;
	 
	 @OneToMany(mappedBy = "course")
	 private List<Review > reviews = new  ArrayList<>();
	 
	 @ManyToMany(mappedBy = "course")
	 private List<Student> students = new  ArrayList<>();
	 
  
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
	   
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review) ;
	}
	
	public void removeReviews(Review review) {
		this.reviews.remove(review) ;
	}
	

	public List<Student> getStudent() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public String getId() {
		return name;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	
}
