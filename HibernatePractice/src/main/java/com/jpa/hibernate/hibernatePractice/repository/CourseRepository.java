package com.jpa.hibernate.hibernatePractice.repository;

import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibernatePractice.entity.Course;
import com.jpa.hibernate.hibernatePractice.entity.Review;


@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
	EntityManager em;
	
	
	public Course findById(Long id){
		return em.find(Course.class,id);
	}
	
	//insert and update 
	public Course save(Course course){
		if(course.getId()==null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
			
	}
	
	public void deleteById(Long id)
	{
		Course course = findById(id);
		em.remove(course);
	}

	public void workWithEntityManager() {
		Course course1 = new Course("Web Services in 100 steps");
		em.persist(course1);
		
		Course course2 = new Course("Web Services in 100 steps");
		em.persist(course2);
		
		em.flush();
		
		//em.detach(course2);
		//em.clear(); update won't be save to DB
		
		course1.setName("Web Services in 100 steps- updated");
		course2.setName("Web Services in 100 steps- updated");
		
	    em.refresh(course1);
		
		em.flush();
	}
	

	

	public void addReviewsForCourse() {
		//get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReviews() ->{}",course.getReviews()); 
		
		//add 2 reviews to it
		Review  review1 = new Review("5","Great hands on stuff");
		Review  review2= new Review("5","Hats off");
		
		course.addReviews(review1);
		review1.setCourse(course);
		
		course.addReviews(review2);
		review2.setCourse(course);
		
		// save it to the database
		em.persist(review1);
		em.persist(review2);
	}
	
}
