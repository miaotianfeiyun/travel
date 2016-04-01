package com.travel.api.third.ctrip.Contract;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "AnnounceGroup")
public class AnnounceGroup {
	@Element(required = false)
	private Date StartDate;
	@Element(required = false)
	private Date EndDate;
	@Element(required = false)
	private String DayOfWeek;

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getDayOfWeek() {
		return DayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}

}
