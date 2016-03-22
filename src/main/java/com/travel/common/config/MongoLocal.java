package com.travel.common.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/** 
 * <p>Title: MongoLocal.java</p>
 * <p>Package Name: com.drolay.common.config</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年1月22日 
 * @version :1.0
 */

public class MongoLocal {
	private ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	public MongoLocal(){
		this.setMongoOperation((MongoOperations)ctx.getBean("mongoTemplate"));
	}
	public MongoOperations getMongoOperation() {
		return mongoOperation;
	}
	public void setMongoOperation(MongoOperations mongoOperation) {
		this.mongoOperation = mongoOperation;
	}
	 private  MongoOperations mongoOperation;
	 
}
