package com.travel.api.third.tuniu.API.core.itinerary;

/** 
 * <p>Title: ItineraryContent.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.travel</p>  
 * <p>Description:行程段描述</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ItineraryContent {
	private String littleTitle;//	Varchar(128)			排序标记
	private String mainBody;//	Varchar(5000)			行程时间
	public String getLittleTitle() {
		return littleTitle;
	}
	public void setLittleTitle(String littleTitle) {
		this.littleTitle = littleTitle;
	}
	public String getMainBody() {
		return mainBody;
	}
	public void setMainBody(String mainBody) {
		this.mainBody = mainBody;
	}
	
}
