package com.travel.api.third.ctrip.Contract;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="BeginSelling")
public class BeginSelling {
@Element(required=false)
private Date StartDate;


public Date getStartDate() {
	return StartDate;
 }

public void setStartDate(Date startdate) {
StartDate = startdate;
}

@Element(required=false)
private Date EndDate;


public Date getEndDate() {
	return EndDate;
 }

public void setEndDate(Date enddate) {
EndDate = enddate;
}

@Element(required=false)
private String DayOfWeek;


public String getDayOfWeek() {
	return DayOfWeek;
 }

public void setDayOfWeek(String dayofweek) {
DayOfWeek = dayofweek;
}

}
