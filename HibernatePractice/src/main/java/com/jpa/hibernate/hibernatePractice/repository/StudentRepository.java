package com.jpa.hibernate.hibernatePractice.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibernatePractice.entity.Course;
import com.jpa.hibernate.hibernatePractice.entity.Passport;
import com.jpa.hibernate.hibernatePractice.entity.Student;


@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;
	
	
	public Student findById(Long id){
		return em.find(Student.class,id);
	}
	
	//insert and update 
	public Student save(Student student){
		if(student.getId()==null) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
			
	}
	
	public void deleteById(Long id)
	{
		Student student = findById(id);
		em.remove(student);
	}

	public void workWithEntityManager() {
		Student student1 = new Student("Web Services in 100 steps");
		em.persist(student1);
		
		Student student2 = new Student("Web Services in 100 steps");
		em.persist(student2);
		
		em.flush();
		
		//em.detach(student2);
		//em.clear(); update won't be save to DB
		
		student1.setName("Web Services in 100 steps- updated");
		student2.setName("Web Services in 100 steps- updated");
		
	    em.refresh(student1);
		
		em.flush();
	}
		
		public void saveStudentWithPassport() {
			
			Passport passport = new Passport("Z123456");
			em.persist(passport);
			
			Student student = new Student("Mike");
			student.setPassport(passport);
			em.persist(student);
	}
		
		public void insertStudentAndCourse(Student student, Course course){
			//Student student = new Student("Piya");
			//Course course = new Course("microservices in 100 steps");
			
			
			student.addCourses(course);
			course.addStudent(student);
			
			em.persist(student);
			em.persist(course);
			
			
		}
	
}
