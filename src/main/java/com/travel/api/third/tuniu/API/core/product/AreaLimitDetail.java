package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: AreaLimitDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:地域限制信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class AreaLimitDetail {
	private int limitType;//	Integer	是		限制类型：0：省，1：市
	private String limitName;//	Varchar(64)	是		名称（如果是省则填省的名字，市则填市的名字） 元/人
	public int getLimitType() {
		return limitType;
	}
	public void setLimitType(int limitType) {
		this.limitType = limitType;
	}
	public String getLimitName() {
		return limitName;
	}
	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}
	
}
