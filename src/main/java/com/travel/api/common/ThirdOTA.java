package com.travel.api.common;

import com.travel.api.common.base.OTAType;

/** 
 * <p>Title: ThirdOTA.java</p>
 * <p>Package Name: com.travel.api.common</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月21日 
 * @version :1.0
 */

public class ThirdOTA {
	
	/** 
	* @Fields appKey : 合作ID
	* @date 2016年3月21日 上午11:10:49 
	*/ 
	private String appKey;
	/** 
	* @Fields appSecret : 合作密码
	* @date 2016年3月21日 上午11:10:59 
	*/ 
	private String appSecret;
	
	/** 
	* @Fields OTAName : 第三方平台类型
	* @date 2016年3月21日 下午2:26:49 
	*/ 
	private OTAType OTAType;
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
	public OTAType getOTAType() {
		return OTAType;
	}
	public void setOTAType(OTAType oTAType) {
		OTAType = oTAType;
	}
	
}
