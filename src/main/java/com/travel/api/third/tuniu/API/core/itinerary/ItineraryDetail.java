package com.travel.api.third.tuniu.API.core.itinerary;

/** 
 * <p>Title: ItineraryDetail.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.travel</p>  
 * <p>Description:行程段信息</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ItineraryDetail {
	private int sort;//	int			排序标记
	private String itineraryTime;//	Varchar(64)			行程时间
	private String itineraryDesc;//	Varchar(64)			行程断描述
	private ItineraryContent[] itineraryContent;//	ItineraryContent[]			小标题和正文
	private String[] itineraryDest;//	Varchar[]			行程目的地，用来匹配图片，多个只取前两个 每个匹配两张图片
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getItineraryTime() {
		return itineraryTime;
	}
	public void setItineraryTime(String itineraryTime) {
		this.itineraryTime = itineraryTime;
	}
	public String getItineraryDesc() {
		return itineraryDesc;
	}
	public void setItineraryDesc(String itineraryDesc) {
		this.itineraryDesc = itineraryDesc;
	}
	public ItineraryContent[] getItineraryContent() {
		return itineraryContent;
	}
	public void setItineraryContent(ItineraryContent[] itineraryContent) {
		this.itineraryContent = itineraryContent;
	}
	public String[] getItineraryDest() {
		return itineraryDest;
	}
	public void setItineraryDest(String[] itineraryDest) {
		this.itineraryDest = itineraryDest;
	}

}
