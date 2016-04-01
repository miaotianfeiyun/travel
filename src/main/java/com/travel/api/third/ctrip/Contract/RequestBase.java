package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

@Root
public class RequestBase {
	@Element(required=false)
	private RequestHeaderType RequestHeader;
	public RequestHeaderType getRequestHeader() {
		return RequestHeader;
	 }
	public void setRequestHeader(RequestHeaderType requestheader) {
		RequestHeader = requestheader;
	}
	public void SetVendorId(long vendorId)
	{
		if (RequestHeader == null)
				this.RequestHeader = new RequestHeaderType();
		this.RequestHeader.setVendorId(vendorId);
	}
	public void SetVendorToken(String vendorToken)
	{
		if (RequestHeader == null)
			this.RequestHeader = new RequestHeaderType();
		this.RequestHeader.setVendorToken(vendorToken);
	}
}
