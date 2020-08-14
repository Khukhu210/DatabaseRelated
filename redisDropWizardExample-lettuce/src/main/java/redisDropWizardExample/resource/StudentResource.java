package redisDropWizardExample.resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;

import io.lettuce.core.api.sync.RedisCommands;
import redisDropWizardExample.cache.CacheConfigManager;
import redisDropWizardExample.domain.Student;
import redisDropWizardExample.service.StudentService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;


@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

	 private static final Logger logger = LoggerFactory.getLogger(StudentResource.class);
	 
	    private static StudentService studentService;
	    private static RedisCommands<String, String> syncCommands ;
	 
	    public StudentResource(StudentService studentService2, RedisCommands<String, String> commands) {
	        this.studentService = studentService;
	        this.syncCommands = commands;
	    }
	 
	   

		@Timed
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getStudentcache() {
	        logger.info("In StudentResource.cache()...Get Student Data");
	        //On the first call, data will be fetched from DB and
	        //cache will be populated with the corresponding student record
	        //On all subsequent calls, data will be returned from the cache
	        for (int i = 1; i < 3; i++) {
	            getStudentData(i);
	        }
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Student Data has been retrieved");
	        return Response.ok(response).build();
	    }
	 
	    private void getStudentData(int i) {
	        logger.info("********** Call " + String.valueOf(i) + " Started **********");
	        logger.info("Call " + String.valueOf(i) + ": {}", CacheConfigManager.getInstance().getStudentDataFromCache("S100",studentService, syncCommands));
	        logger.info("Call " + String.valueOf(i) + ": {}", CacheConfigManager.getInstance().getStudentDataFromCache("M101",studentService, syncCommands));
	        logger.info("Call " + String.valueOf(i) + ": {}", CacheConfigManager.getInstance().getStudentDataFromCache("P102",studentService, syncCommands));
	        logger.info("Call " + String.valueOf(i) + ": {}", CacheConfigManager.getInstance().getStudentDataFromCache("P105",studentService, syncCommands));
	        logger.info("Call " + String.valueOf(i) + ": {}", CacheConfigManager.getInstance().getStudentDataFromCache("P106",studentService, syncCommands));
	        logger.info("********** Call " + String.valueOf(i) + " Ended **********");
	    }
}
