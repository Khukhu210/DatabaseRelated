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
class NativeQueriesTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
    EntityManager em;

	@Test
	public void native_queries_basic() {

		Query query = em.createNativeQuery("SELECT * From COURSE", Course.class);
		List resultList = query.getResultList();
		logger.info("SELECT * From COURSE ->{}", resultList);

	}
	
	@Test
	public void native_queries_with_parameter() {

		Query query = em.createNativeQuery("SELECT * From COURSE where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * From COURSE where id = :id ->{}", resultList);

	}


}
