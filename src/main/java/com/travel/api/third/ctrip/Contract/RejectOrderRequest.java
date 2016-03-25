package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "RejectOrderRequest")
public class RejectOrderRequest extends RequestBase {
	@Element(required = false)
	private String OrderId;
	@Element(required = false)
	private String VendorOrderId;
	@Element(required = false)
	private String MessageId;
	@Element(required = false)
	private String Reason;

	public String getVendorOrderId() {
		return VendorOrderId;
	}

	public void setVendorOrderId(String vendorOrderId) {
		VendorOrderId = vendorOrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getMessageId() {
		return MessageId;
	}

	public void setMessageId(String messageid) {
		MessageId = messageid;
	}

	public String getOrderId() {
		return OrderId;
	}

}
