package com.travel.mongo.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.travel.api.common.product.ProductClient;

/** 
 * <p>Title: ProductDao.java</p>
 * <p>Package Name: com.travel.mongo.dao</p>  
 * <p>Description:TODO </p> 
 * @author liujq
 * @date  :2016年3月31日 
 * @version :1.0
 */
@Repository  
public class ProductDao {
	  public static final Logger logger = Logger.getLogger(ProductDao.class);  
	  
	    @Autowired  
	    private MongoTemplate mongoTemplate;  
	  
	    public void _test() {  
	        Set<String> colls = this.mongoTemplate.getCollectionNames();  
	        for (String coll : colls) {  
	            logger.info("CollectionName=" + coll);  
	        }  
	        DB db = this.mongoTemplate.getDb();  
	        logger.info("db=" + db.toString());  
	    }  
	  
	    public void createCollection() {  
	        if (!this.mongoTemplate.collectionExists(ProductClient.class)) {  
	            this.mongoTemplate.createCollection(ProductClient.class);  
	        }  
	    }  
	  
	    public List<ProductClient> findList(int skip, int limit) {  
	        Query query = new Query();  
	        query.with(new Sort(new Order(Direction.ASC, "_id")));  
	        query.skip(skip).limit(limit);  
	        return this.mongoTemplate.find(query, ProductClient.class);  
	    }  
	  
	    public List<ProductClient> findListByAge(int age) {  
	        Query query = new Query();  
	        query.addCriteria(new Criteria("age").is(age));  
	        return this.mongoTemplate.find(query, ProductClient.class);  
	    }  
	  
	    public ProductClient findOne(String id) {  
	        Query query = new Query();  
	        query.addCriteria(new Criteria("_id").is(id));  
	        return this.mongoTemplate.findOne(query, ProductClient.class);  
	    }  
	  
	    public ProductClient findOneByUsername(String username) {  
	        Query query = new Query();  
	        query.addCriteria(new Criteria("name.username").is(username));  
	        return this.mongoTemplate.findOne(query, ProductClient.class);  
	    }  
	  
	    public void insert(ProductClient entity) {  
	        this.mongoTemplate.insert(entity);  
	  
	    }  
	  
	    public void update(ProductClient entity) {  
	        Query query = new Query();  
//	        query.addCriteria(new Criteria("_id").is(entity.getToken()));  
//	        Update update = new Update();  
//	        update.set("age", entity.getAge());  
//	        update.set("password", entity.getPassword());  
//	        update.set("regionName", entity.getRegionName());  
//	        update.set("special", entity.getSpecial());  
//	        update.set("works", entity.getWorks());  
//	        update.set("name", entity.getName());  
//	        this.mongoTemplate.updateFirst(query, update, ProductClient.class);  
	  
	    }  
}
