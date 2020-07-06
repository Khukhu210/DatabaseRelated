package com.jpa.hibernate.hibernatePractice.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibernatePractice.HibernatePracticeApplication;
import com.jpa.hibernate.hibernatePractice.entity.Passport;
import com.jpa.hibernate.hibernatePractice.entity.Student;

@SpringBootTest(classes=HibernatePracticeApplication.class)
class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	

	@Test
	@Transactional
	public void retrieveStudentAndPassortDetails() {
		Student student = em.find(Student.class,20001L);
		logger.info("student ->{}",student);
	    logger.info("passport ->{}",student.getPassport());
		
		}
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class,40001L);
		logger.info("passport ->{}",passport);
	    logger.info("student ->{}",passport.getStudent());
	}

}
