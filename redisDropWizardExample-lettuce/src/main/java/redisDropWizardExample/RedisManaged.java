package redisDropWizardExample;
import java.util.Map;

import io.dropwizard.lifecycle.Managed;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import redisDropWizardExample.domain.Student;

public class RedisManaged implements Managed {
     private StatefulRedisConnection<String, String> connection ; 
     private RedisClient client ;
     private RedisCommands<String, String> commands ;
	 
	    public RedisManaged(RedisClient client, StatefulRedisConnection<String, String> connection,  RedisCommands<String, String> commands) {
	        this.connection = connection;
	        this.client = client;
	        this.commands = commands;
	        
	    }
	 
	    

		@Override
	    public void start() throws Exception {
	    	commands.flushall();
	    }
	 
	    @Override
	    public void stop() throws Exception {
	    	commands.flushall();
	        connection.close();
	        client.shutdown();
	    }
}
