package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.BaseResponseNoData;
import com.travel.api.third.tuniu.API.core.productAuditStatus.ProductStatusQueryResult;

/** 
 * <p>Title: ProductAuditStatusResponse.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:查询产品审核状态返回 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月22日 
 * @version :1.0
 */

public class ProductAuditStatusResponse extends BaseResponseNoData{

	private  ProductStatusQueryResult[] data;

	public ProductStatusQueryResult[] getData() {
		return data;
	}
	
	public void setData(ProductStatusQueryResult[] data) {
		this.data = data;
	}
 
 
}
