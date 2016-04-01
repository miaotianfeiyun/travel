package com.travel.api.common.product.base;

import java.util.Date;

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
	private Date StartDate;
	
	/** 
	* @Fields EndDate : 结束日期
	* @date 2016年3月18日 上午10:51:48 
	*/ 
	@Element(required=false)
	private Date EndDate;
	
	/** 
	* @Fields DayOfWeek : 每周的有效班期。若每天都有班期则为1234567, 124则为周一、二、四开班
	* @date 2016年3月18日 上午10:52:00 
	*/ 
	@Element(required=false)
	private String DayOfWeek;

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getDayOfWeek() {
		return DayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}
}
