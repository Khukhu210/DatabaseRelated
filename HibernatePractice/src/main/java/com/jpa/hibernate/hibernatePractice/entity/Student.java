package com.jpa.hibernate.hibernatePractice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	public String getId() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	
	
	
}
