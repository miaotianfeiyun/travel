package com.travel.common.datesource;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/** 
 * <p>Title: DataSourceAdvice.java</p>
 * <p>Package Name: com.drolay.common</p>  
 * <p>Description:TODO </p> 
 * <p>Company: liantuobank.com</p> 
 * @author liujq
 * @date  :2015年5月14日 
 * @version :1.0
 */

public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	 // service方法执行之前被调用  
	public void Before(Method method, Object[] args, Object target) throws Throwable {  
		 if(method.getName().startsWith("add")   
		            || method.getName().startsWith("create")  
		            || method.getName().startsWith("save")  
		            || method.getName().startsWith("edit")  
		            || method.getName().startsWith("update")  
		            || method.getName().startsWith("delete")  
		            || method.getName().startsWith("remove")){  
		            System.out.println("切换到: master");  
		            DataSourceSwitcher.setMaster();  
		        }  
		        else  {  
		            System.out.println("切换到: slave");  
		            DataSourceSwitcher.setSlave();  
		        }  
	}
	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		DataSourceSwitcher.setSlave();  
        System.out.println("出现异常,切换到: slave");  
		
	}

}
