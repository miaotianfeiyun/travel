package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class CancelOrderResponse  extends ResponseBase  {
@Element(required=false)
private OrderResultType Result ;


public OrderResultType getResult() {
	return Result;
 }

public void setResult(OrderResultType result) {
Result = result;
}

@Element(required=false)
private String VendorOrderId ;


public String getVendorOrderId() {
	return VendorOrderId;
 }

public void setVendorOrderId(String vendororderid) {
VendorOrderId = vendororderid;
}

@Element(required=false)
private String RejectReason ;


public String getRejectReason() {
	return RejectReason;
 }

public void setRejectReason(String rejectreason) {
RejectReason = rejectreason;
}

}
