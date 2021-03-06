package com.jpa.hibernate.hibernatePractice;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.hibernatePractice.entity.Course;
import com.jpa.hibernate.hibernatePractice.entity.Review;
import com.jpa.hibernate.hibernatePractice.entity.Student;
import com.jpa.hibernate.hibernatePractice.repository.CourseRepository;
import com.jpa.hibernate.hibernatePractice.repository.StudentRepository;

@SpringBootApplication
public class HibernatePracticeApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;


	public static void main(String[] args) {
		SpringApplication.run(HibernatePracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/*
		 * Course course = courseRepository.findById(10001L);
		 * logger.info("Course 10001 ->{}",course); 
		 * courseRepository.deleteById(10001L);
		 * courseRepository.save(new Course("Hibernate in 100 steps"));
		 */
		 
		
		//courseRepository.workWithEntityManager();
		//studentRepository.saveStudentWithPassport();
		
		// List<Review> reviews = new ArrayList<>();
		//reviews.add(new Review("5","Great hands on stuff"));
		//reviews.add(new Review("5","Hatsoff"));
		//courseRepository.addReviewsForCourse(10003L, reviews );
		
		studentRepository.insertStudentAndCourse(new Student("Piya"),
		new Course("microservices in 100 steps"));
	
	}

}
