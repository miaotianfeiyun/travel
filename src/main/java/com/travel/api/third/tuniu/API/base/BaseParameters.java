package com.travel.api.third.tuniu.API.base;

/** 
 * <p>Title: BaseParameters.java</p>
 * <p>Package Name: com.drolay.tuniu.API.base</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class BaseParameters {
	/** 
	* 分配给供应商的唯一身份标识
	*/ 
	private String apiKey;
	/** 
	* 请求签名，生成规则参见签名机制
	*/ 
	private String sign;
	/** 
	*时间戳，参见时间戳 
	*/ 
	private String timestamp;
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
