package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ConfirmOrderRequest")
public class ConfirmOrderRequest extends RequestBase {
	@Element(required = false)
	private String OrderId;

	@Element(required = false)
	private String VendorOrderId;

	@Element(required = false)
	private String MessageId;

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderid) {
		OrderId = orderid;
	}

	public String getVendorOrderId() {
		return VendorOrderId;
	}

	public void setVendorOrderId(String vendororderid) {
		VendorOrderId = vendororderid;
	}

	public String getMessageId() {
		return MessageId;
	}

	public void setMessageId(String messageid) {
		MessageId = messageid;
	}

}
