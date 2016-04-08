package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "AnnounceGroup")
public class AnnounceGroup {
	@Element(required = false)
	private String StartDate;
	@Element(required = false)
	private String EndDate;
	@Element(required = false)
	private String DayOfWeek;

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getDayOfWeek() {
		return DayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}

}
