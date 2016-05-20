package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: LiveAttentionDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:住宿提示信息</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class LiveAttentionDetail {
	private int type;//	Integer	是	0	拼房选择：0：不愿拼房，1：与亲友加床
	private int washFlag;//	Integer	是	0	是否提供洗漱用品：0：不提供，1：提供
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getWashFlag() {
		return washFlag;
	}
	public void setWashFlag(int washFlag) {
		this.washFlag = washFlag;
	}
	
}
