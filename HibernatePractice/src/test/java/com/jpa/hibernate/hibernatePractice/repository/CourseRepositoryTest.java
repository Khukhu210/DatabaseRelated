package com.jpa.hibernate.hibernatePractice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibernatePractice.HibernatePracticeApplication;
import com.jpa.hibernate.hibernatePractice.entity.Course;
import com.jpa.hibernate.hibernatePractice.entity.Review;

@SpringBootTest(classes=HibernatePracticeApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	public void findById() {
		logger.info("Testing is run");
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps",course.getName());
		
	}
	
	@Test
	@Transactional
	public void retrieveReviewsForCourse()
	{
		Course course = repository.findById(10001L);
		logger.info("{}",course.getReviews());
	}
	

	@Test
	@Transactional
	public void retrieveCourseForReview()
	{
		Review review = em.find(Review.class, 50001L);
		logger.info("{}",review.getCourse());
	}

}
