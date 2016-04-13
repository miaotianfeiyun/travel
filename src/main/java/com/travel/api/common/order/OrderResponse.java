package com.travel.api.common.order;

import com.travel.api.common.base.CommonResponse;

/** 
 * <p>Title: OrderResponse.java</p>
 * <p>Package Name: com.travel.api.common.order</p>  
 * <p>Description:TODO </p> 
 * @author liujq
 * @date  :2016年4月12日 
 * @version :1.0
 */

public class OrderResponse extends CommonResponse{
	public OrderResponse(){};
	public OrderResponse(String errorcode,String errormsg,String remark){
		super.setErrorCode(errorcode);
		super.setErrorMsg(errormsg);
		super.setRemark(remark);
	}
}
