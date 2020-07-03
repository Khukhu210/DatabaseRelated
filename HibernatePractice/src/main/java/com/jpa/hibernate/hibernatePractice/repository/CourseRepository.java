package com.jpa.hibernate.hibernatePractice.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibernatePractice.entity.Course;


@Repository
@Transactional
public class CourseRepository {

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
	
}
