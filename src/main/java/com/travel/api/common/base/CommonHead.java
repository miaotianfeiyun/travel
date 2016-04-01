package com.travel.api.common.base;

/** 
 * <p>Title: CommonHead.java</p>
 * <p>Package Name: com.travel.api.common.base</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月14日 
 * @version :1.0
 */

public class CommonHead {
	private String appKey;
	private String appSecret;
	private String token;
	private String timeStamp;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
