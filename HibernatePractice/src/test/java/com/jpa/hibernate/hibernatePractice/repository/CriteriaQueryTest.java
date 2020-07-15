package com.jpa.hibernate.hibernatePractice.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.hibernate.hibernatePractice.HibernatePracticeApplication;
import com.jpa.hibernate.hibernatePractice.entity.Course;

@SpringBootTest(classes=HibernatePracticeApplication.class)
class CriteriaQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
    EntityManager em;

	@Test
	  public void all_courses() {
	  
	  // 1. use of criteria builder to create criteria query return expected result
	  // object
	  
	  CriteriaBuilder cb = em.getCriteriaBuilder(); 
	  CriteriaQuery<Course> cq = cb.createQuery(Course.class);
	  
	  // 2.define roots for tables which are involved 
	  Root<Course> courseRoot =cq.from(Course.class);
	  
	  TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
	  List<Course> resultList = query.getResultList();
	  logger.info("Typed Query having all courses->{}", resultList);
	  
	  }
	 
	
	  @Test
	  public void all_Courses_Having_50Steps() {
	  
	  CriteriaBuilder cb = em.getCriteriaBuilder(); 
	  CriteriaQuery<Course> cq = cb.createQuery(Course.class);
	  Root<Course> courseRoot = cq.from(Course.class);
	  
	  //3.Define Predicates etc using criteria Builder 
	  
	  Predicate like50Steps = cb.like(courseRoot.get("name"),"%50 Steps");
	  
	  //4.Add Predicates to the criteria query 
	  cq.where(like50Steps);
	  
	  TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
	  List<Course> resultList = query.getResultList();
	  logger.info("Typed Query courses having 50 steps->{}", resultList);
	  
	  }
	 
      @Test
	  public void all_Courses_Without_Students() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		
		Predicate StudentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
		cq.where(StudentsIsEmpty);
		
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query courses without Student->{}", resultList);
		
		//output [Course [name=Spring in 50 steps]] 
	}
      @Test
	  public void join() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		
		Join<Object,Object> join = courseRoot.join("students",JoinType.LEFT);
		
		
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query using join->{}", resultList);
		
		
       
	}



}
