package com.jpa.hibernate.hibernatePractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.hibernatePractice.entity.Course;
import com.jpa.hibernate.hibernatePractice.repository.CourseRepository;

@SpringBootApplication
public class HibernatePracticeApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HibernatePracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/*
		 * Course course = repository.findById(10001L);
		 * logger.info("Course 10001 ->{}",course); 
		 * repository.deleteById(10001L);
		 * repository.save(new Course("Hibernate in 100 steps"));
		 */
		 
		repository.workWithEntityManager();
	
	}

}
