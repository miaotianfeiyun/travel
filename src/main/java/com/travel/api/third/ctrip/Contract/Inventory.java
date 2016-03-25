package com.travel.api.third.ctrip.Contract;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="Inventory")
public class Inventory {
@Element(required=false)
private Date StartDate ;


public Date getStartDate() {
	return StartDate;
 }

public void setStartDate(Date startdate) {
StartDate = startdate;
}

@Element(required=false)
private Date EndDate ;


public Date getEndDate() {
	return EndDate;
 }

public void setEndDate(Date enddate) {
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

@ElementList(required=false)
private List<PackageInventoryInfo> PackageInventoryInfoList ;


public List<PackageInventoryInfo> getPackageInventoryInfoList() {
	return PackageInventoryInfoList;
 }

public void setPackageInventoryInfoList(List<PackageInventoryInfo> packageinventoryinfolist) {
PackageInventoryInfoList = packageinventoryinfolist;
}

}
