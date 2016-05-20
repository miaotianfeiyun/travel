package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.BaseParameters;
import com.travel.api.third.tuniu.API.core.productAuditStatus.ProductStatusInfo;

/** 
 * <p>Title: ProductAuditStatus.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:产品审核状态查询</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月21日 
 * @version :1.0
 */

public class ProductAuditStatus extends BaseParameters{
	/** 
	* 支持多个查询 
	*/ 
	private ProductStatusInfo[]	productStatusList;

	public ProductStatusInfo[] getProductStatusList() {
		return productStatusList;
	}

	public void setProductStatusList(ProductStatusInfo[] productStatusList) {
		this.productStatusList = productStatusList;
	}
	
}
