package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: InnerTrafficInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:小交通信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class InnerTrafficInfo {
	private int innerTrafficFlag;//	Integer	是		包含小交通：0：不包含，1：包含
	private int 	innerTrafficType;//	Integer	是		小交通类型：0：往返，1：去程，2：回程， 如果交通不包含小交通，则此字段不存在
	private String innerTrafficRemark;//	Varchar(256)	否		小交通描述（从某地到某地）
	private int 	scenicCarFlag;//	Integer	是		是否存在景区内用车，0：不存在，1：存在
	private String scenicCarRemark;//	Varchar(256)	否		景区内用车描述
	public int getInnerTrafficFlag() {
		return innerTrafficFlag;
	}
	public void setInnerTrafficFlag(int innerTrafficFlag) {
		this.innerTrafficFlag = innerTrafficFlag;
	}
	public int getInnerTrafficType() {
		return innerTrafficType;
	}
	public void setInnerTrafficType(int innerTrafficType) {
		this.innerTrafficType = innerTrafficType;
	}
	public String getInnerTrafficRemark() {
		return innerTrafficRemark;
	}
	public void setInnerTrafficRemark(String innerTrafficRemark) {
		this.innerTrafficRemark = innerTrafficRemark;
	}
	public int getScenicCarFlag() {
		return scenicCarFlag;
	}
	public void setScenicCarFlag(int scenicCarFlag) {
		this.scenicCarFlag = scenicCarFlag;
	}
	public String getScenicCarRemark() {
		return scenicCarRemark;
	}
	public void setScenicCarRemark(String scenicCarRemark) {
		this.scenicCarRemark = scenicCarRemark;
	}
	
}
