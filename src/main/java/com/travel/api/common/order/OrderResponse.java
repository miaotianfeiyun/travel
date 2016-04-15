package com.travel.api.common.order;

import com.travel.api.common.base.CommonResponse;
import com.travel.api.common.order.base.OrderResultType;

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
	private OrderResultType result ;

	private String vendorOrderId ;

	private String rejectReason ;

	public OrderResultType getResult() {
		return result;
	}
	public void setResult(OrderResultType result) {
		this.result = result;
	}
	public String getVendorOrderId() {
		return vendorOrderId;
	}
	public void setVendorOrderId(String vendorOrderId) {
		this.vendorOrderId = vendorOrderId;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
}
