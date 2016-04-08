package com.travel.api.common.product.base;

import org.simpleframework.xml.Element;

/** 
 * <p>Title: BeginSelling.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:班期信息 </p> 
 *  
 * @author liujq
 * @date  :2016年3月18日 
 * @version :1.0
 */

public class Selling {
	/** 
	* @Fields StartDate : 开始日期
	* @date 2016年3月18日 上午10:51:42 
	*/ 
	@Element(required=false)
	private String StartDate;
	
	/** 
	* @Fields EndDate : 结束日期
	* @date 2016年3月18日 上午10:51:48 
	*/ 
	@Element(required=false)
	private String EndDate;
	
	/** 
	* @Fields DayOfWeek : 每周的有效班期。若每天都有班期则为1234567, 124则为周一、二、四开班
	* @date 2016年3月18日 上午10:52:00 
	*/ 
	@Element(required=false)
	private String DayOfWeek;
	
	/** 
	* @Fields Reason : 班期关闭原因
	* @date 2016年4月8日 下午4:30:47 
	*/ 
	@Element(required=false)
	private String Reason;
	

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getDayOfWeek() {
		return DayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}
}
