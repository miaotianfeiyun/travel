package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: ActiveDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:活动信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ActiveDetail {
	private String activeName;//	Varchar(256)	否		活动名称
	private int activeCost;//	Integer	否	0	参考价格
	private String activeContent;//	Varchar(256)	否		活动内容
	private String remark;//	Varchar(256)	否		备注信息
	public String getActiveName() {
		return activeName;
	}
	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}
	public int getActiveCost() {
		return activeCost;
	}
	public void setActiveCost(int activeCost) {
		this.activeCost = activeCost;
	}
	public String getActiveContent() {
		return activeContent;
	}
	public void setActiveContent(String activeContent) {
		this.activeContent = activeContent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
