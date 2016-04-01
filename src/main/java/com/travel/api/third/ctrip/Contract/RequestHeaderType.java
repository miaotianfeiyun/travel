package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

@Root
public class RequestHeaderType {
	
	@Element(required=false)
	private long VendorId;
	@Element(required=false)
	private String VendorToken;
	public long getVendorId() {
		return VendorId;
	}
	public void setVendorId(long vendorId) {
		VendorId = vendorId;
	}
	public String getVendorToken() {
		return VendorToken;
	}
	public void setVendorToken(String vendorToken) {
		VendorToken = vendorToken;
	}

}