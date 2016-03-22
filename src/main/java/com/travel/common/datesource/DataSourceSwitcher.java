package com.travel.common.datesource;



/** 
 * <p>Title: DataSourceSwitcher.java</p>
 * <p>Package Name: com.drolay.common</p>  
 * <p>Description:TODO </p> 
 * <p>Company: liantuobank.com</p> 
 * @author liujq
 * @date  :2015年5月14日 
 * @version :1.0
 */

public class DataSourceSwitcher {
	@SuppressWarnings("rawtypes")
	private static final ThreadLocal contentHolder=new ThreadLocal();
	@SuppressWarnings("unchecked")
	public static void setDataSource(String dateSource){
		contentHolder.set(dateSource);
	}
	public static void setMaster(){
		clearDateSource();
	}
	public static void setSlave(){
		setDataSource("slave");
	}
	public static String getDateSource(){
		return (String) contentHolder.get();
	}
	public static void clearDateSource(){
		contentHolder.remove();
	}
}
