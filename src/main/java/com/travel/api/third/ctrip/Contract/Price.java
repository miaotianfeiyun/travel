package com.travel.api.third.ctrip.Contract;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root(name="Price")
public class Price {
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
private List<PackagePriceInfo> PackagePriceInfoList ;


public List<PackagePriceInfo> getPackagePriceInfoList() {
	return PackagePriceInfoList;
 }

public void setPackagePriceInfoList(List<PackagePriceInfo> packagepriceinfolist) {
PackagePriceInfoList = packagepriceinfolist;
}

@ElementList(required=false)
private List<OptionPriceInfo> OptionPriceInfoList ;


public List<OptionPriceInfo> getOptionPriceInfoList() {
	return OptionPriceInfoList;
 }

public void setOptionPriceInfoList(List<OptionPriceInfo> optionpriceinfolist) {
OptionPriceInfoList = optionpriceinfolist;
}

}
