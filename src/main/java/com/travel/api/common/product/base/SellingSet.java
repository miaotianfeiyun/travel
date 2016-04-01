package com.travel.api.common.product.base;

import java.util.List;

import org.simpleframework.xml.ElementList;
/** 
 * <p>Title: BeginSelling.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:班期设置，打开的班期同时也宣布成团</p> 
 *  
 * @author liujq
 * @date  :2016年3月18日 
 * @version :1.0
 */

public class SellingSet {

	
	/** 
	* @Fields type : true-打开，false-关闭
	* @date 2016年3月18日 上午11:37:21 
	*/ 
	private boolean type;
	
	/** 
	* @Fields SellingList : 班期列表
	* @date 2016年3月18日 上午10:53:14 
	*/ 
	@ElementList(required=false)
	private List<Selling> SellingList ;
	
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public List<Selling> getSellingList() {
		return SellingList;
	}
	public void setSellingList(List<Selling> sellingList) {
		SellingList = sellingList;
	}

}
