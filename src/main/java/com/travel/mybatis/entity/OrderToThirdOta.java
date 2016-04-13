/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.travel.mybatis.entity;

import java.util.Date;

/** 
 * <p>Title: OrderToThirdOtaMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public class OrderToThirdOta implements java.io.Serializable{
	
	/**
	 * @param vendororderid
	 * @param thirdorderid
	 * @param sn
	 * @param third_type
	 * @param interface_name
	 * @param real_action
	 * @param request_xml
	 * @param response_xml
	 * @param request_time
	 * @param response_time
	 */
	public OrderToThirdOta(String vendororderid, String thirdorderid,
			String sn, String third_type, String interface_name,
			String real_action, String request_xml, String response_xml,
			Date request_time, Date response_time) {
		super();
		this.vendororderid = vendororderid;
		this.thirdorderid = thirdorderid;
		this.sn = sn;
		this.third_type = third_type;
		this.interface_name = interface_name;
		this.real_action = real_action;
		this.request_xml = request_xml;
		this.response_xml = response_xml;
		this.request_time = request_time;
		this.response_time = response_time;
	}

	/**
	 * @param id
	 * @param response_xml
	 * @param response_time
	 */
	public OrderToThirdOta(Integer id,String response_xml,Date response_time) {
		super();
		this.id = id;
		this.response_xml = response_xml;
		this.response_time = response_time;
	}

	private static final long serialVersionUID = 5454155825314635342L;
	
	/*
	 * 主键	
	 */
	private Integer id;
	/*
	 * 供应商订单号	
	 */
	private String vendororderid;
	/*
	 * 第三方订单号	
	 */
	private String thirdorderid;
	/*
	 * 	
	 */
	private String sn;
	/*
	 * 第三方类型	
	 */
	private String third_type;
	/*
	 * 接口名称	
	 */
	private String interface_name;
	/*
	 * 供应商真实的动作	
	 */
	private String real_action;
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

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setVendororderid(String vendororderid) {
		this.vendororderid = vendororderid;
	}
	
	public String getVendororderid() {
		return this.vendororderid;
	}
	public void setThirdorderid(String thirdorderid) {
		this.thirdorderid = thirdorderid;
	}
	
	public String getThirdorderid() {
		return this.thirdorderid;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public String getSn() {
		return this.sn;
	}
	public void setThird_type(String third_type) {
		this.third_type = third_type;
	}
	
	public String getThird_type() {
		return this.third_type;
	}
	public void setInterface_name(String interface_name) {
		this.interface_name = interface_name;
	}
	
	public String getInterface_name() {
		return this.interface_name;
	}
	public void setReal_action(String real_action) {
		this.real_action = real_action;
	}
	
	public String getReal_action() {
		return this.real_action;
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

}

