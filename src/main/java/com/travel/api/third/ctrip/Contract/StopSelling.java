package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="StopSelling")
public class StopSelling {
@Element(required=false)
private String StartDate ;


public String getStartDate() {
	return StartDate;
 }

public void setStartDate(String startdate) {
StartDate = startdate;
}

@Element(required=false)
private String EndDate ;


public String getEndDate() {
	return EndDate;
 }

public void setEndDate(String enddate) {
EndDate = enddate;
}

@Element(required=false)
private String DayOfWeek ;


public String getDayOfWeek() {
	return DayOfWeek;
 }

public void setDayOfWeek(String dayofweek) {
DayOfWeek = dayofweek;
}

@Element(required=false)
private String Reason ;


public String getReason() {
	return Reason;
 }

public void setReason(String reason) {
Reason = reason;
}

}
