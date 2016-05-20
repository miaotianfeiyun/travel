package com.travel.api.third.tuniu.API.core.itinerary;

/** 
 * <p>Title: ScheduleContent.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.travel</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ScheduleContent {
	private int day;//	int			行程第几天
	private String title;//	Varchar(256)			行程标题
	private ItineraryDetail[] itineraryList;//	ItineraryDetail[]			行程段
	private String desc;//	Varchar(1024)			描述
	private MealInfo mealInfo;//	MealInfo			用餐信息
	private String liveInfo;//	Varchar(1024)			住宿信息
	private ShopRecommend[] shopRecommend	;//ShopRecommend[]			购物店信息
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ItineraryDetail[] getItineraryList() {
		return itineraryList;
	}
	public void setItineraryList(ItineraryDetail[] itineraryList) {
		this.itineraryList = itineraryList;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MealInfo getMealInfo() {
		return mealInfo;
	}
	public void setMealInfo(MealInfo mealInfo) {
		this.mealInfo = mealInfo;
	}
	public String getLiveInfo() {
		return liveInfo;
	}
	public void setLiveInfo(String liveInfo) {
		this.liveInfo = liveInfo;
	}
	public ShopRecommend[] getShopRecommend() {
		return shopRecommend;
	}
	public void setShopRecommend(ShopRecommend[] shopRecommend) {
		this.shopRecommend = shopRecommend;
	}
	
}
