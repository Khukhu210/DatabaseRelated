package com.jpa.hibernate.hibernatePractice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.hibernate.hibernatePractice.HibernatePracticeApplication;
import com.jpa.hibernate.hibernatePractice.entity.Course;

@SpringBootTest(classes=HibernatePracticeApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	CourseRepository repository;

	@Test
	public void findById() {
		logger.info("Testing is run");
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps",course.getName());
		
		
	}

}
