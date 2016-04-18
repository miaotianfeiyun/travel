package com.travel.api.common.product.base;

import java.io.Serializable;
import java.util.List;

/** 
 * <p>Title: Itinerary.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:行程 </p> 
 *  
 * @author liujq
 * @date  :2016年3月15日 
 * @version :1.0
 */

public class Itinerary   implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields Day : 行程段顺序，即第几天行程。1~20，不得重复，1起步顺序增长
	* @date 2016年3月15日 上午11:00:22 
	*/ 
	private int Day;
	/** 
	* @Fields ItineraryName : 每日行程名称。示例：北京-上海
	* @date 2016年3月15日 上午11:00:49 
	*/ 
	private String ItineraryName;
	/** 
	* @Fields ItineraryDescription : 行程描述信息
	* @date 2016年3月15日 上午11:01:21 
	*/ 
	private String ItineraryDescription;
	/** 
	* @Fields AccommdationDescription : 行程住宿标注。若不提供可在行程描述中包含
	* @date 2016年3月15日 上午11:33:50 
	*/ 
	private String AccommdationDescription;
	/** 
	* @Fields MealDescription : 行程餐饮标准。若不提供可在行程描述中包含
	* @date 2016年3月15日 上午11:34:01 
	*/ 
	private String MealDescription;
	/** 
	* @Fields POIList : 每日行程中包含的景点
	* @date 2016年3月15日 上午10:47:57 
	*/ 
	private List<POI> POIList;
	public int getDay() {
		return Day;
	}
	public void setDay(int day) {
		Day = day;
	}
	public String getItineraryName() {
		return ItineraryName;
	}
	public void setItineraryName(String itineraryName) {
		ItineraryName = itineraryName;
	}
	public String getItineraryDescription() {
		return ItineraryDescription;
	}
	public void setItineraryDescription(String itineraryDescription) {
		ItineraryDescription = itineraryDescription;
	}
	public String getAccommdationDescription() {
		return AccommdationDescription;
	}
	public void setAccommdationDescription(String accommdationDescription) {
		AccommdationDescription = accommdationDescription;
	}
	public String getMealDescription() {
		return MealDescription;
	}
	public void setMealDescription(String mealDescription) {
		MealDescription = mealDescription;
	}
	public List<POI> getPOIList() {
		return POIList;
	}
	public void setPOIList(List<POI> pOIList) {
		POIList = pOIList;
	}

}
