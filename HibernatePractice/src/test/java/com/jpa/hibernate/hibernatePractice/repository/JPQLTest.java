package com.jpa.hibernate.hibernatePractice.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.hibernate.hibernatePractice.HibernatePracticeApplication;
import com.jpa.hibernate.hibernatePractice.entity.Course;

@SpringBootTest(classes=HibernatePracticeApplication.class)
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
    EntityManager em;

	@Test
	public void jpql_Basic() {
		//logger.info("Testing is run");
	Query query =	em.createQuery("select c from Course c");
	List resultList = query.getResultList();
	logger.info("select c from Course c ->{}",resultList);
		
		
	}
	
	@Test
	public void jpql_Typed() {
		
	TypedQuery<Course> query =	em.createNamedQuery("query_get_all_courses",Course.class);
	List resultList = query.getResultList();
	logger.info("select c from Course c ->{}",resultList);
		
		
	}
	
	@Test
	public void jpql_where() {
		
	TypedQuery<Course> query =	em.createNamedQuery("query_get_100_Steps_courses",Course.class);
	List resultList = query.getResultList();
	logger.info("select c from Course c where name like '%100 Steps' ->{}",resultList);
		
		
	}


}
