package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ConfirmOrderRequest")
public class ConfirmOrderRequest  extends RequestBase  {
@Element(required=false)
private long OrderId ;


public long getOrderId() {
	return OrderId;
 }

public void setOrderId(long orderid) {
OrderId = orderid;
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
private String MessageId ;


public String getMessageId() {
	return MessageId;
 }

public void setMessageId(String messageid) {
MessageId = messageid;
}

}
