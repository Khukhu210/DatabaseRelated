package com.learning.hibernate.database.HibernateDemo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
public class Person {
	
  @javax.persistence.Id
  @GeneratedValue
  private int Id;
  private String Name;
  private String Location;
  private Date Birthdate;
  
  public Person()
  {
	  
  }

public Person(int id, String name, String location, Date birthdate) {
	Id = id;
	Name = name;
	Location = location;
	Birthdate = birthdate;
}
public Person(String name, String location, Date birthdate) {
	
	Name = name;
	Location = location;
	Birthdate = birthdate;
}

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getLocation() {
	return Location;
}

public void setLocation(String location) {
	Location = location;
}

public Date getBirthDate() {
	return Birthdate;
}

public void setBirthDate(Date birthdate) {
	Birthdate = birthdate;
}

@Override
public String toString() {
	return "Person [Id=" + Id + ", Name=" + Name + ", Location=" + Location + ", Birthdate=" + Birthdate + "]";
}


  
}
