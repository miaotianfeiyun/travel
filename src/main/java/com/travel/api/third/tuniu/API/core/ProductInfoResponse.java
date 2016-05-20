package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.NotifyResponseBase;
import com.travel.api.third.tuniu.API.core.product.BaseInfoResultDate;

/** 
 * <p>Title: ProductInfoResponse.java</p>
 * <p>Package Name: com.drolay.tuniu.API</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月4日 
 * @version :1.0
 */

public class ProductInfoResponse extends NotifyResponseBase{
	/** 
	* 执行结果
	*/ 
	private BaseInfoResultDate data;

	public BaseInfoResultDate getData() {
		return data;
	}

	public void setData(BaseInfoResultDate data) {
		this.data = data;
	} 
	
}
