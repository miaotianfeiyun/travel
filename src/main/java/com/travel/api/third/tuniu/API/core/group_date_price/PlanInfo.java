package com.travel.api.third.tuniu.API.core.group_date_price;

/** 
 * <p>Title: PlanInfo.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:团期信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class PlanInfo {
	private String planDateStr;//	Varchar(10)	是	2015-07-18	团期
	private DatePriceDetail[] datePriceList;//	DatePriceDetail[]	是		相应价格方案的集合
	public String getPlanDateStr() {
		return planDateStr;
	}
	public void setPlanDateStr(String planDateStr) {
		this.planDateStr = planDateStr;
	}
	public DatePriceDetail[] getDatePriceList() {
		return datePriceList;
	}
	public void setDatePriceList(DatePriceDetail[] datePriceList) {
		this.datePriceList = datePriceList;
	}
	
}
