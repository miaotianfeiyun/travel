package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class PriceType {
@Element(required=false)
private String StartDate ;
;

public String getStartDate() {	return StartDate;}

public void setStartDate(String startdate) {StartDate = startdate;}
@Element(required=false)
private String EndDate ;
;

public String getEndDate() {	return EndDate;}

public void setEndDate(String enddate) {EndDate = enddate;}
@Element(required=false)
private String DayOfWeek ;
;

public String getDayOfWeek() {	return DayOfWeek;}

public void setDayOfWeek(String dayofweek) {DayOfWeek = dayofweek;}
@Element(required=false)
private List<PackagePriceInfo> PackagePriceInfoList ;
;

public List<PackagePriceInfo> getPackagePriceInfoList() {	return PackagePriceInfoList;}

public void setPackagePriceInfoList(List<PackagePriceInfo> packagepriceinfolist) {PackagePriceInfoList = packagepriceinfolist;}
@Element(required=false)
private List<OptionPriceInfo> OptionPriceInfoList ;
;

public List<OptionPriceInfo> getOptionPriceInfoList() {	return OptionPriceInfoList;}

public void setOptionPriceInfoList(List<OptionPriceInfo> optionpriceinfolist) {OptionPriceInfoList = optionpriceinfolist;}
}
