package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class CreateOrderResponse  extends ResponseBase  {
	@Element(required=false)
	private OrderResultType Result ;

	@Element(required=false)
	private String VendorOrderId ;
	
	@Element(required=false)
	private String RejectReason ;

	public OrderResultType getResult() {
		return Result;
	 }
	
	public void setResult(OrderResultType result) {
	Result = result;
	}
	
	public String getVendorOrderId() {
		return VendorOrderId;
	 }
	
	public void setVendorOrderId(String vendororderid) {
	VendorOrderId = vendororderid;
	}
	
	public String getRejectReason() {
		return RejectReason;
	 }
	
	public void setRejectReason(String rejectreason) {
	RejectReason = rejectreason;
	}

}
