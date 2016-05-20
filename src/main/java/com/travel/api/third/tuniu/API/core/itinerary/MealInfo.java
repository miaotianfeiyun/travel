package com.travel.api.third.tuniu.API.core.itinerary;

/** 
 * <p>Title: MealInfo.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.travel</p>  
 * <p>Description:行程中的用餐信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class MealInfo {
	private String morning;//	Varchar(64)	否		早餐
	private String noon;//	Varchar(64)	否		午餐
	private String night;//	Varchar(64)	否		晚餐
	public String getMorning() {
		return morning;
	}
	public void setMorning(String morning) {
		this.morning = morning;
	}
	public String getNoon() {
		return noon;
	}
	public void setNoon(String noon) {
		this.noon = noon;
	}
	public String getNight() {
		return night;
	}
	public void setNight(String night) {
		this.night = night;
	}
	

}
