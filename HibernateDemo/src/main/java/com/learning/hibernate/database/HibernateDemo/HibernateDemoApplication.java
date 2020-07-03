package com.learning.hibernate.database.HibernateDemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.hibernate.database.HibernateDemo.entity.Person;
import com.learning.hibernate.database.HibernateDemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Thread.sleep(2000);
		
		logger.info("All users ->{}",repository.findAll());
		
		logger.info("Users id 10001 ->{}",repository.findById(10001));
		
		logger.info("Inserting  ->{}",
				repository.insert(new Person(10004, "Tara","Delhi",new Date())));
		
		logger.info("Updating 10004 ->{}",
				repository.update(new Person(10003, "Rani","Pune",new Date())));
		
		repository.deleteById(10002);
		
		
		
		
	}

}
