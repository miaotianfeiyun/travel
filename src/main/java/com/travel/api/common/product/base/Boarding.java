package com.travel.api.common.product.base;

/** 
 * <p>Title: ProductBoardingDetail.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:上车地点 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月16日 
 * @version :1.0
 */

public class Boarding {
	/** 
	* @Fields Location : 上车地点地址
	* @date 2016年3月16日 下午6:06:12 
	*/ 
	private String Location;
	/** 
	* @Fields Time : 上车时间，格式为HH:mm
	* @date 2016年3月16日 下午6:07:30 
	*/ 
	private String Time;
	/** 
	* @Fields Price : 费用
	* @date 2016年3月16日 下午6:07:38 
	*/ 
	private double Price;
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
}
