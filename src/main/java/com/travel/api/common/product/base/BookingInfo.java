package com.travel.api.common.product.base;

/** 
 * <p>Title: BookingInfo.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:预定控制信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月15日 
 * @version :1.0
 */
public class BookingInfo {
	/** 
	* @Fields ProductContact : 供应商产品联系人
	* @date 2016年3月15日 上午11:52:50 
	*/ 
	private String ProductContact;
	/** 
	* @Fields ProductContactMobile : 供应商产品联系人手机号
	* @date 2016年3月15日 上午11:53:09 
	*/ 
	private String ProductContactMobile; 
	/** 
	* @Fields IsSMSNotify : 新订单是否短信通知(false-不通知；true-通知) 此字段对于一些平台不支持
	* @date 2016年3月15日 上午11:53:33 
	*/ 
	private boolean IsSMSNotify;
	/** 
	* @Fields EmergencyContact : 紧急联系人，可以同产品咨询联系人。客人出行过程中遇问题联系携程，携程OP可能需联系紧急联系人
	* @date 2016年3月15日 上午11:54:30 
	*/ 
	private String EmergencyContact;
	/** 
	* @Fields EmergencyContactMobile : 紧急联系人手机号
	* @date 2016年3月15日 下午1:36:40 
	*/ 
	private String EmergencyContactMobile;
	
	/** 
	* @Fields IsPublishEmergencyContact : 是否公布紧急联系人(false-不公布；true-公布)
	* @date 2016年3月15日 下午1:37:15 
	*/ 
	private boolean IsPublishEmergencyContact;
	/** 
	* @Fields AdvancedCloseDays : 提前关闭售卖天数，比如国内游提前5天停止售卖；周边游提前1天停止售卖。
	* @date 2016年3月15日 下午1:37:45 
	*/ 
	private int AdvancedCloseDays;
	
	/** 
	* @Fields AdvancedCloseTime : 提前关闭售卖时间，格式HH:mm（24小时制），比如周边提前1天16点停止售卖，默认12:00
	* @date 2016年3月15日 下午1:38:07 
	*/ 
	private String AdvancedCloseTime;
	/** 
	* @Fields IsWeekendWork : 是否周末工作(true-工作；false-不工作)，默认为工作
	* @date 2016年3月15日 下午1:49:25 
	*/ 
	private boolean IsWeekendWork;
	/** 
	* @Fields IsHolidayWork : 是否节假日工作(true-工作；true-不工作)，默认为工作
	* @date 2016年3月15日 下午1:49:39 
	*/ 
	private boolean IsHolidayWork;
	public String getProductContact() {
		return ProductContact;
	}
	public void setProductContact(String productContact) {
		ProductContact = productContact;
	}
	public String getProductContactMobile() {
		return ProductContactMobile;
	}
	public void setProductContactMobile(String productContactMobile) {
		ProductContactMobile = productContactMobile;
	}
	public boolean isIsSMSNotify() {
		return IsSMSNotify;
	}
	public void setIsSMSNotify(boolean isSMSNotify) {
		IsSMSNotify = isSMSNotify;
	}
	public String getEmergencyContact() {
		return EmergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		EmergencyContact = emergencyContact;
	}
	public String getEmergencyContactMobile() {
		return EmergencyContactMobile;
	}
	public void setEmergencyContactMobile(String emergencyContactMobile) {
		EmergencyContactMobile = emergencyContactMobile;
	}
	public boolean isIsPublishEmergencyContact() {
		return IsPublishEmergencyContact;
	}
	public void setIsPublishEmergencyContact(boolean isPublishEmergencyContact) {
		IsPublishEmergencyContact = isPublishEmergencyContact;
	}
	public int getAdvancedCloseDays() {
		return AdvancedCloseDays;
	}
	public void setAdvancedCloseDays(int advancedCloseDays) {
		AdvancedCloseDays = advancedCloseDays;
	}
	public String getAdvancedCloseTime() {
		return AdvancedCloseTime;
	}
	public void setAdvancedCloseTime(String advancedCloseTime) {
		AdvancedCloseTime = advancedCloseTime;
	}
	public boolean isIsWeekendWork() {
		return IsWeekendWork;
	}
	public void setIsWeekendWork(boolean isWeekendWork) {
		IsWeekendWork = isWeekendWork;
	}
	public boolean isIsHolidayWork() {
		return IsHolidayWork;
	}
	public void setIsHolidayWork(boolean isHolidayWork) {
		IsHolidayWork = isHolidayWork;
	}
	
	
}
