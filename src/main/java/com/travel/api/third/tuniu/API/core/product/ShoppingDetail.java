package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: ShoppingDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:购物店信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ShoppingDetail {
	private String shoppingName;//	Varchar(256)	是		购物店名称
	private String businessProduct;//	Varchar(256)	是		营业产品
	private String remark;//	Varchar(256)	否		说明
	public String getShoppingName() {
		return shoppingName;
	}
	public void setShoppingName(String shoppingName) {
		this.shoppingName = shoppingName;
	}
	public String getBusinessProduct() {
		return businessProduct;
	}
	public void setBusinessProduct(String businessProduct) {
		this.businessProduct = businessProduct;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
