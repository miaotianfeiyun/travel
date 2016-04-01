package com.travel.common.util;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;


/** 
* <p>Title: ParameterRequestWrapper.java</p>
* <p>Package Name: com.drolay.common.util</p>  
* <p>Description:TODO </p> 
*  
* @author liujq
* @date  :2015年9月7日 
* @version :1.0
*/ 
public class ParameterRequestWrapper extends HttpServletRequestWrapper{


	public ParameterRequestWrapper(HttpServletRequest request, Map<?, ?> newParams) {
		super(request);
	}
	/**
	   * 根据指定的参数名，返回去除前后空白字符的参数值。
	   * @param name  参数名
	   * @return 去除前后空格的参数值
	   * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	   */
	  @Override
	  public String getParameter(String name) {
		  String returnStr="";
		  if("keywords".equals(name) || "keyword".equals(name)){
			  if(StringUtils.isNoneBlank(super.getParameter(name))){
				  returnStr=(super.getParameter(name).equals("请输入关键字"))?"":(super.getParameter(name));
			  }else{
				  returnStr=super.getParameter(name);
			  }
	    	}else{
	    		returnStr=super.getParameter(name);
	    	}
		  return HtmlUtils.htmlEscape(returnStr);
	  }
	  /**
	   * 返回参数名-参数值数组映射，其中的参数数组将被去除前后空白字符。
	   * @return 去除空白字符的参数名-参数值数组映射
	   * @see javax.servlet.ServletRequestWrapper#getParameterMap()
	   */
	  @SuppressWarnings("unchecked")
	  @Override
	  public Map<String, String[]> getParameterMap() {
	    Map<String, String[]> parameterMap = new LinkedHashMap<String, String[]>();
	    Enumeration<String> names = super.getParameterNames();
	    while (names.hasMoreElements()) {
	      String name = names.nextElement();
	      parameterMap.put(name, getParameterValues(name));
	    }
	    return parameterMap;
	  }
	 
	  /**
	   * 根据指定的参数名，返回去除前后空格的参数值数组。
	   * @param name 参数名
	   * @return 去除前后空格的参数值数组
	   * @see javax.servlet.ServletRequestWrapper#getParameterValues(java.lang.String)
	   */
	   @Override
	  public String[] getParameterValues(String name){
		   String[] values=null;
		   if(StringUtils.isNoneBlank(super.getParameterValues(name))){
			   if("keywords".equals(name) || "keyword".equals(name)){
				   	values = super.getParameterValues(name).clone();
				    for (int i = 0; i < values.length; i++) {
				    	if("keywords".equals(name) || "keyword".equals(name)){
				    		if(values[i].equals("请输入关键字")){
				    			values[i]="";
				    		}
				    	}else{
				    		values[i] =values[i];
				    	}
				      
				    }
			   }else{
				   values= super.getParameterValues(name);
			   }
		   }else{
			   values= super.getParameterValues(name);
		   }
		   //替换页面标签
		   String newStr[]=null;
		   for (int i = 0; i < values.length; i++) {
			   String temp=HtmlUtils.htmlEscape(values[i]);
			   values[i]=temp;
		   }
		   return newStr;
	  }
	  
}
