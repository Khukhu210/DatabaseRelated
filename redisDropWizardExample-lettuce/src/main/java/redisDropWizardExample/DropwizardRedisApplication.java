package redisDropWizardExample;


import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redisDropWizardExample.domain.Student;
import redisDropWizardExample.resource.DropwizardRedisHealthCheckResource;
import redisDropWizardExample.resource.StudentResource;
import redisDropWizardExample.service.StudentService;

public class DropwizardRedisApplication extends Application<DropwizardRedisConfiguration> {
	private static final Logger logger = LoggerFactory.getLogger(DropwizardRedisApplication.class);
	 
	 public static void main(String[] args) throws Exception {
	  new DropwizardRedisApplication().run("server", args[0]);
	 }
	 
	    @Override
	    public void initialize(Bootstrap<DropwizardRedisConfiguration> b) {
	    }
	 
	 @Override
	 public void run(DropwizardRedisConfiguration config, Environment env)
	   throws Exception {
	        //Connect to 127.0.0.1:6379 by default
	     //RedissonClient redissonClient = Redisson.create();
		 
		 
			/*
			 * RedisURI redisUri = RedisURI.Builder.redis("localhost",6379)
			 * .withPassword("pass@12345") .withDatabase(2) .build(); RedisClient client =
			 * RedisClient.create(redisUri);
			 */
         RedisClient client = RedisClient.create(RedisURI.create("localhost", 6379));
	     
	     StatefulRedisConnection<String, String> connection = client.connect();
	     RedisCommands<String, String> commands = connection.sync();
	     RedisManaged redisManaged = new RedisManaged(client, connection, commands);
	        env.lifecycle().manage(redisManaged);
	     StudentService studentService = new StudentService();
	     logger.info("Registering RESTful API resources");
	 
	        env.jersey().register(new StudentResource(studentService, commands));
	        env.healthChecks().register("DropwizardCacheHealthCheck",
	        	    new DropwizardRedisHealthCheckResource(config));
	 }
}
