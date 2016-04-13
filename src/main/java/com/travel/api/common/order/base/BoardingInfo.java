package com.travel.api.common.order.base;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

@Root
public class BoardingInfo {
	@Element(required=false)
	private String Location;
	
	@Element(required=false)
	private String Price;
	
	@Element(required=false)
	private String Time;

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

}
