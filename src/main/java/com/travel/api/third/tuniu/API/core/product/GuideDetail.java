package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: GuideDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:导服信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class GuideDetail {
	private int guideType;	//Integer	是	0	导服类型：0：当地中文导游，1：专职中文领队兼导游（境外），全程陪同中文导游（境内），2：专职领队和当地中文导游（境外），全陪和当地中文导游（境内）
	private String guideRemark;//	Varchar(256)	否		导服说明
	public int getGuideType() {
		return guideType;
	}
	public void setGuideType(int guideType) {
		this.guideType = guideType;
	}
	public String getGuideRemark() {
		return guideRemark;
	}
	public void setGuideRemark(String guideRemark) {
		this.guideRemark = guideRemark;
	}
	
}
