/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.travel.mybatis.entity;

/** 
 * <p>Title: ProductAuditContentMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public class ProductAuditContent implements java.io.Serializable{
	public ProductAuditContent(){}
	private static final long serialVersionUID = 5454155825314635342L;
	public ProductAuditContent(String product_code,String request_xml,String app_key,String app_secret,String is_notify){
		this.product_code=product_code;
		this.request_xml=request_xml;
		this.app_key=app_key;
		this.app_secret=app_secret;
		this.is_notify=is_notify;
	}
	/*
	 * 	
	 */
	private Integer id;
	/*
	 * 产品编码	
	 */
	private String product_code;
	/*
	 * 第三方返回的报文	
	 */
	private String request_xml;
	/*
	 * 供应商key	
	 */
	private String app_key;
	/*
	 * 供应商value	
	 */
	private String app_secret;
	/*
	 * 是否已通知供应商 Y-已通知 N-未通知	
	 */
	private String is_notify;
	/*
	 * 携程请求时间	
	 */
	private java.util.Date request_time;
	/*
	 * 成功发送到供应商系统时间	
	 */
	private java.util.Date send_success_time;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
	public String getProduct_code() {
		return this.product_code;
	}
	public void setRequest_xml(String request_xml) {
		this.request_xml = request_xml;
	}
	
	public String getRequest_xml() {
		return this.request_xml;
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
	public void setIs_notify(String is_notify) {
		this.is_notify = is_notify;
	}
	
	public String getIs_notify() {
		return this.is_notify;
	}
	public void setRequest_time(java.util.Date request_time) {
		this.request_time = request_time;
	}
	
	public java.util.Date getRequest_time() {
		return this.request_time;
	}
	
	public void setSend_success_time(java.util.Date send_success_time) {
		this.send_success_time = send_success_time;
	}
	
	public java.util.Date getSend_success_time() {
		return this.send_success_time;
	}

}

