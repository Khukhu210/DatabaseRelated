package redisDropWizardExample.cache;

import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.api.sync.RedisCommands;
import redisDropWizardExample.domain.Student;
import redisDropWizardExample.service.StudentService;


public class CacheConfigManager {
	  private static final Logger logger = LoggerFactory.getLogger(CacheConfigManager.class);
	  
	    private static CacheConfigManager cacheConfigManager = new CacheConfigManager();
	 
	    public static CacheConfigManager getInstance() {
	        return cacheConfigManager;
	    }
	 
	    //Logic For Student Cache
	    public String getStudentDataFromCache(String key, StudentService studentService, RedisCommands<String, String> syncCommands) {
	        try {
	            String student;
	            if(CollectionUtils.sizeIsEmpty(syncCommands.scan().getKeys())){
	                student = studentService.getFromDatabase(key);
	                syncCommands.set(key, student);
	            }
	            else{
	                if(syncCommands.get(key) != null){
	                    student =  syncCommands.get(key);
	                }
	                else{
	                    student = studentService.getFromDatabase(key);
	                    syncCommands.set(key, student);
	                }
	            }
	            logger.info("All Entries in Student map: {}",syncCommands.scan().getKeys());
	            return student.toString();
	        } catch (Exception e) {
	            logger.error("Error Retrieving Elements from the Student Cache"
	                    + e.getMessage());
	            return null;
	        }
	    }
}
