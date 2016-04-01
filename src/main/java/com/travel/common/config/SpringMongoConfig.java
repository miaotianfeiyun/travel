package com.travel.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/** 
 * <p>Title: SpringMongoConfig.java</p>
 * <p>Package Name: com.drolay.common.config</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年1月22日 
 * @version :1.0
 */
//@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Override
    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(),"test");
    }
	@Override
	public Mongo mongo() throws Exception {
		MongoClient client=new MongoClient("127.0.0.1",27017);
		return client;
	}
	@Override
	protected String getDatabaseName() {
		return "test";
	}

}
