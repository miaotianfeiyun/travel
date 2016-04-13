package com.travel.api.common.base;


/** 
 * <p>Title: ClientBase.java</p>
 * <p>Package Name: com.travel.api.common.base</p>  
 * <p>Description:TODO </p> 
 * @author liujq
 * @date  :2016年4月11日 
 * @version :1.0
 */

public class ClientBase {
	public static final String productDealUrl="/v1/product/addOrModify.in";
	public static final String orderDealUrl="/v1/product/orderDeal.in";
	/** 
	* @Fields appKey : 连接接口平台的key
	* @date 2016年3月21日 下午6:07:35 
	*/ 
	private String appKey;
	/** 
	* @Fields appSecret : 连接接口平台的secret
	* @date 2016年3月21日 下午6:07:56 
	*/ 
	private String appSecret;
	
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
	
}
