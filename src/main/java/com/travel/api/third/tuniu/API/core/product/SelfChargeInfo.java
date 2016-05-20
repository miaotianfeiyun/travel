package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: SelfChargeInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:活动推荐信息</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class SelfChargeInfo {
	private ShoppingDetail[] shoppingList;//	ShoppingDetail[]	否		购物店信息
	private ActiveDetail[] activeList;//	ActiveDetail[]	否		活动推荐
	private String remark;//	Varchar(1024)	否		说明
	public ShoppingDetail[] getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ShoppingDetail[] shoppingList) {
		this.shoppingList = shoppingList;
	}
	public ActiveDetail[] getActiveList() {
		return activeList;
	}
	public void setActiveList(ActiveDetail[] activeList) {
		this.activeList = activeList;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
