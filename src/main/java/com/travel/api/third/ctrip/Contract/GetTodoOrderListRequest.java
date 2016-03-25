package com.travel.api.third.ctrip.Contract;

import java.util.Date;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

@Root(name = "GetTodoOrderListRequest")
public class GetTodoOrderListRequest extends RequestBase {
	
	@Element(required=false)
	private String StartDateTime;


public String getStartDateTime() {
	return StartDateTime;
 }

public void setStartDateTime(String startdatetime) {
StartDateTime = startdatetime;
}
	
	@Element(required=false)
	private String EndDateTime;


public String getEndDateTime() {
	return EndDateTime;
 }

public void setEndDateTime(String enddatetime) {
EndDateTime = enddatetime;
}
	
	public void SetStartDateTime(Date start)
	{
		this.StartDateTime = start.toString();
	}
	
	public void SetEndDateTime(Date end)
	{
		this.EndDateTime = end.toString();
	}
	
	public void SetVendorId(long vendorId)
	{
		super.SetVendorId(vendorId);
	}
	
	public void SetVendorToken(String vendorToken)
	{
		super.SetVendorToken(vendorToken);
	}
}
