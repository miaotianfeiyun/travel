package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: AimHotelDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:邮轮/酒店等信息详情 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */
public class AimHotelDetail {
	private String destination;//	Varchar(64)	是		目的地
	private int nightTimes;//	Integer	否	0	入住多少晚
	private String remark;//	Varchar(256)	否				备注
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNightTimes() {
		return nightTimes;
	}
	public void setNightTimes(int nightTimes) {
		this.nightTimes = nightTimes;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
