package com.travel.api.common.product.base;

import java.util.List;

/** 
 * <p>Title: ProductBoarding.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:上车地点 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月16日 
 * @version :1.0
 */

public class ProductBoarding {
	/** 
	* @Fields ProductCode : 供应商产品编号
	* @date 2016年3月16日 下午6:08:48 
	*/ 
	private String ProductCode;
	/** 
	* @Fields BoardingList : 上车地点列表
	* @date 2016年3月16日 下午6:09:20 
	*/ 
	private List<Boarding> BoardingList;
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public List<Boarding> getBoardingList() {
		return BoardingList;
	}
	public void setBoardingList(List<Boarding> boardingList) {
		BoardingList = boardingList;
	}
	
}
