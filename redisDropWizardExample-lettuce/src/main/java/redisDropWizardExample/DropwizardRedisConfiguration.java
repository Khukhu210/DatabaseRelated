package redisDropWizardExample;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
 
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropwizardRedisConfiguration extends Configuration {

    @JsonProperty
    public String appName;
 
    @JsonProperty
    public String studentCacheKey;
 
    public String getAppName() {
        return appName;
    }
 
    public void setAppName(String appName) {
        this.appName = appName;
    }
 
    public String getStudentCacheKey() {
        return studentCacheKey;
    }
 
    public void setStudentCacheKey(String studentCacheKey) {
        this.studentCacheKey = studentCacheKey;
    }
}
