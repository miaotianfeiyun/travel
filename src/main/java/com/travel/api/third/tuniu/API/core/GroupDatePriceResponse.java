package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.NotifyResponseBase;
import com.travel.api.third.tuniu.API.core.group_date_price.DateChangeResult;

/** 
 * <p>Title: GroupDatePriceResponse.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月8日 
 * @version :1.0
 */

public class GroupDatePriceResponse extends NotifyResponseBase{
	private DateChangeResult data;//	否		实际执行结果

	public DateChangeResult getData() {
		return data;
	}

	public void setData(DateChangeResult data) {
		this.data = data;
	}
	
}
