/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.travel.mybatis.entity;

import java.util.Date;

/** 
 * <p>Title: ProductToTopMapper.java</p>
 * <p>Description: </p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public class ProductToTop implements java.io.Serializable{
	public ProductToTop(){};
	
	/**
	 * @param product_code
	 * @param appkey
	 * @param appsecret
	 * @param sn
	 * @param request_xml
	 * @param response_xml
	 * @param request_time
	 * @param response_time
	 * @param real_action
	 */
	public ProductToTop(Integer id,String product_code, String appkey, String appsecret,
			String sn, String request_xml, String response_xml,
			Date request_time, Date response_time, String real_action) {
		super();
		this.id=id;
		this.product_code = product_code;
		this.appkey = appkey;
		this.appsecret = appsecret;
		this.sn = sn;
		this.request_xml = request_xml;
		this.response_xml = response_xml;
		this.request_time = request_time;
		this.response_time = response_time;
		this.real_action = real_action;
	}

	private static final long serialVersionUID = 5454155825314635342L;
	
	/*
	 * 	
	 */
	private Integer id;
	/*
	 * 产品编码	
	 */
	private String product_code;
	/*
	 * top平台合作key	
	 */
	private String appkey;
	/*
	 * top平台合作密钥	
	 */
	private String appsecret;
	/*
	 * 处理流水号	
	 */
	private String sn;
	/*
	 * 请求报文	
	 */
	private String request_xml;
	/*
	 * 返回报文	
	 */
	private String response_xml;
	/*
	 * 请求时间	
	 */
	private java.util.Date request_time;
	/*
	 * 返回时间	
	 */
	private java.util.Date response_time;
	/*
	 * 供应商真实的动作 A-添加 U-更新	
	 */
	private String real_action;

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
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	
	public String getAppkey() {
		return this.appkey;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	
	public String getAppsecret() {
		return this.appsecret;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public String getSn() {
		return this.sn;
	}
	public void setRequest_xml(String request_xml) {
		this.request_xml = request_xml;
	}
	
	public String getRequest_xml() {
		return this.request_xml;
	}
	public void setResponse_xml(String response_xml) {
		this.response_xml = response_xml;
	}
	
	public String getResponse_xml() {
		return this.response_xml;
	}
	public void setRequest_time(java.util.Date request_time) {
		this.request_time = request_time;
	}
	
	public java.util.Date getRequest_time() {
		return this.request_time;
	}
	public void setResponse_time(java.util.Date response_time) {
		this.response_time = response_time;
	}
	
	public java.util.Date getResponse_time() {
		return this.response_time;
	}
	public void setReal_action(String real_action) {
		this.real_action = real_action;
	}
	
	public String getReal_action() {
		return this.real_action;
	}

}

