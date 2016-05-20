package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: VisaExplain.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:签证信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class VisaExplain {
	private int visaType;//	Integer	是	0	签证类型：0：免签证，1：团队旅游签证，2：落地签证
	private int visaCost;//	Integer	否	0	签证费用 元/人,如果免签证，此字段不存在
	public int getVisaType() {
		return visaType;
	}
	public void setVisaType(int visaType) {
		this.visaType = visaType;
	}
	public int getVisaCost() {
		return visaCost;
	}
	public void setVisaCost(int visaCost) {
		this.visaCost = visaCost;
	}
	
}
