package com.travel.api.common.order;

import org.simpleframework.xml.Element;

import com.travel.api.common.order.base.Order;
import com.travel.api.common.order.base.OrderDealType;


/** 
 * <p>Title: CommonOrderRequest.java</p>
 * <p>Package Name: com.drolay.distribution.order.common</p>  
 * <p>Description:订单客户端</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年11月3日 
 * @version :1.0
 */

public class OrderRequest {
	/**
	 * 第三方合作key
	 */
	@Element
	private  String appKey;
	/**
	 * 第三方合作code
	 */
	@Element
	private  String appSecret;
	/** 
	*拒绝时需要填写
	*/ 
	@Element(required = false)
	private String Reason;
	/** 
	* 供应商订单号
	*/ 
	@Element(required = false)
	private String VendorOrderId;
	
	/** 
	* 订单所属的平台
	*/ 
	@Element(required=true)
	private String cooperationPlatform;
	
	/** 
	* 处理类型
	*/ 
	@Element(required=false)
	private OrderDealType dealType;
	
	/** 
	* 各种操作的订单信息 
	*/ 
	@Element(required=false)
	private Order order;
	
	public OrderDealType getDealType() {
		return dealType;
	}
	public void setDealType(OrderDealType dealType) {
		this.dealType = dealType;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getCooperationPlatform() {
		return cooperationPlatform;
	}

	public void setCooperationPlatform(String cooperationPlatform) {
		this.cooperationPlatform = cooperationPlatform;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getVendorOrderId() {
		return VendorOrderId;
	}
	public void setVendorOrderId(String vendorOrderId) {
		VendorOrderId = vendorOrderId;
	}
	
}
