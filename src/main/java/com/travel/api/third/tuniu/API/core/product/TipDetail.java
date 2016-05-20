package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: TipDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:小费信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class TipDetail {
	private int tipFlag;//	Integer	是	0	是否存在司机导游小费：0：不存在，1存在
	private int tipCost;//	Integer	否		当存在小费时的价格 元/人
	private String remark;//	Varchar(256)	否		当存在小时费的说明
	public int getTipFlag() {
		return tipFlag;
	}
	public void setTipFlag(int tipFlag) {
		this.tipFlag = tipFlag;
	}
	public int getTipCost() {
		return tipCost;
	}
	public void setTipCost(int tipCost) {
		this.tipCost = tipCost;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
