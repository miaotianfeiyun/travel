//package com.travel.controller;
//
//import java.util.Date;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.travel.common.mapper.User;
//import com.travel.mybatis.dao.UserMapper;
//
///** 
// * <p>Title: MongoTes.java</p>
// * <p>Package Name: com.travel.controller</p>  
// * <p>Description:TODO </p> 
// *  
// * @author liujq
// * @date  :2016年3月11日 
// * @version :1.0
// */
//
//public class MongoTes {
//	 UserMapper pr;
//    /** 
//     *  
//     *<b>function:</b> 
//     * @author cuiran 
//     * @createDate 2012-12-12 16:08:02 
//     */  
//    public void init(){  
//         ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-common.xml");  
//          pr= (UserMapper)ctx.getBean("userMapper");  
//    }  
//    /** 
//     *  
//     *<b>function:</b>添加 
//     * @author cuiran 
//     * @createDate 2012-12-12 16:11:01 
//     */  
//    public void insert(){  
//          
//        User p=new User();  
//        p.setAddress("beijing");
//        p.setAgency_code("A_11111");
//        p.setCreate_date(new Date());
//        p.setMobile("18210424665");
//        p.setUsername("liujq");
//        pr.insert(p);  
//    }  
//    public static void main(String[] args) {  
//        // TODO Auto-generated method stub  
//    	MongoTes t=new MongoTes();  
//        t.init();  
//        t.insert();
//    }  
//}
