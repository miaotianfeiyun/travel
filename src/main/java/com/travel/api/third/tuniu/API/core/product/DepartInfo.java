package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: DepartInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:发车信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class DepartInfo {
	private String departTitle;//	Varchar(128)	否		发车基本信息
	private String emergencyContactInfo;//	Varchar(128)	否		紧急联系人及电话
	private int autoSendNoticeFlag;//	Integer	是	0	自动发送出团通知：0：否，1：是
	private DepartDetail[] departList;//	DepartDetail[];//	否		发车信息详情
	private int pickUpFlag;//	Integer	是	0	接送机（站）服务：0：不提供，1：提供 2：有条件提供
	private int pickUpType;//	Integer	是	0	接送服务：1：接送都含2：只接不送3：只送不接
	private String pickUpTraffic;//	Varchar(16)	否	1,2	指定交通方式：:1:飞机，2：火车，逗号分割
	private String pickUpNotes;//	Varchar(256)	否		接车信息备注（条件备注）
	private ContactDetail[] contactList;//	ContactDetail[]	否		联系人信息
	private String routeInfoRemark;//	Varchar(256)	否		线路信息备注
	public String getDepartTitle() {
		return departTitle;
	}
	public void setDepartTitle(String departTitle) {
		this.departTitle = departTitle;
	}
	public String getEmergencyContactInfo() {
		return emergencyContactInfo;
	}
	public void setEmergencyContactInfo(String emergencyContactInfo) {
		this.emergencyContactInfo = emergencyContactInfo;
	}
	public int getAutoSendNoticeFlag() {
		return autoSendNoticeFlag;
	}
	public void setAutoSendNoticeFlag(int autoSendNoticeFlag) {
		this.autoSendNoticeFlag = autoSendNoticeFlag;
	}
	public DepartDetail[] getDepartList() {
		return departList;
	}
	public void setDepartList(DepartDetail[] departList) {
		this.departList = departList;
	}
	public int getPickUpFlag() {
		return pickUpFlag;
	}
	public void setPickUpFlag(int pickUpFlag) {
		this.pickUpFlag = pickUpFlag;
	}
	public int getPickUpType() {
		return pickUpType;
	}
	public void setPickUpType(int pickUpType) {
		this.pickUpType = pickUpType;
	}
	public String getPickUpTraffic() {
		return pickUpTraffic;
	}
	public void setPickUpTraffic(String pickUpTraffic) {
		this.pickUpTraffic = pickUpTraffic;
	}
	public String getPickUpNotes() {
		return pickUpNotes;
	}
	public void setPickUpNotes(String pickUpNotes) {
		this.pickUpNotes = pickUpNotes;
	}
	public ContactDetail[] getContactList() {
		return contactList;
	}
	public void setContactList(ContactDetail[] contactList) {
		this.contactList = contactList;
	}
	public String getRouteInfoRemark() {
		return routeInfoRemark;
	}
	public void setRouteInfoRemark(String routeInfoRemark) {
		this.routeInfoRemark = routeInfoRemark;
	}
	
}
