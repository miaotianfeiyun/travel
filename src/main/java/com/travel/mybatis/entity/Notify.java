/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.travel.mybatis.entity;

/** 
 * <p>Title: ProductAuditNotifyMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public class Notify implements java.io.Serializable{
	public Notify(){};
	private static final long serialVersionUID = 5454155825314635342L;
	public Notify(String app_key,String app_secret){
		this.app_key=app_key;
		this.app_secret=app_secret;
	}
	/*
	 * 	
	 */
	private Integer id;
	/*
	 * 供应商合作key	
	 */
	private String app_key;
	/*
	 * 供应商合作value	
	 */
	private String app_secret;
	/*
	 * 通知地址	
	 */
	private String notify_url;
	/*
	 * 通知类型	
	 */
	private String notify_type;
	/*
	 * 第三方类型	
	 */
	private String third_type;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}
	
	public String getApp_key() {
		return this.app_key;
	}
	public void setApp_secret(String app_secret) {
		this.app_secret = app_secret;
	}
	
	public String getApp_secret() {
		return this.app_secret;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	
	public String getNotify_url() {
		return this.notify_url;
	}
	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}
	
	public String getNotify_type() {
		return this.notify_type;
	}
	public void setThird_type(String third_type) {
		this.third_type = third_type;
	}
	
	public String getThird_type() {
		return this.third_type;
	}

}

