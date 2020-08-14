package redisDropWizardExample.service;

import redisDropWizardExample.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.util.HashMap;
import java.util.Map;

public class StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	 
    public StudentService() {
    }
 
    public static String getFromDatabase(String universityId) {
        Student student1 = new Student("Jiya", "S100", "Science");
        Student student2 = new Student("Siye", "M101", "Maths");
        Student student3 = new Student("Micky", "P102", "ECE");
        Student student4 = new Student("Khushi", "P105", "CSE");
        Student student5 = new Student("Divya", "P106", "CSE");
        Map<String, Student> database = new HashMap<>();
        database.put("S100", student1);
        database.put("M101", student2);
        database.put("P102", student3);
        database.put("P105", student4);
        database.put("P106", student5);
        logger.info("Database called for: {}", universityId);
        return database.get(universityId).toString();
    }
}
