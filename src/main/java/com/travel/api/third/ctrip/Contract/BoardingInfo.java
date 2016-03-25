package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

@Root
public class BoardingInfo {
	@Element(required=false)
	private String Location;


public String getLocation() {
	return Location;
 }

public void setLocation(String location) {
Location = location;
}
	
	@Element(required=false)
	private String Price;


public String getPrice() {
	return Price;
 }

public void setPrice(String price) {
Price = price;
}
	
	@Element(required=false)
	private String Time;


public String getTime() {
	return Time;
 }

public void setTime(String time) {
Time = time;
}
}
