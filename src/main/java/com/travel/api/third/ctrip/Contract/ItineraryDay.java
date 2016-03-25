package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root(name="ItineraryDay")
public class ItineraryDay {
@Element(required=false)
private int Day ;


public int getDay() {
	return Day;
 }

public void setDay(int day) {
Day = day;
}

@Element(required=false)
private String ItineraryName ;


public String getItineraryName() {
	return ItineraryName;
 }

public void setItineraryName(String itineraryname) {
ItineraryName = itineraryname;
}

@Element(required=false)
private String ItineraryDescription ;


public String getItineraryDescription() {
	return ItineraryDescription;
 }

public void setItineraryDescription(String itinerarydescription) {
ItineraryDescription = itinerarydescription;
}

@Element(required=false)
private String AccommdationDescription ;


public String getAccommdationDescription() {
	return AccommdationDescription;
 }

public void setAccommdationDescription(String accommdationdescription) {
AccommdationDescription = accommdationdescription;
}

@Element(required=false)
private String MealDescription ;


public String getMealDescription() {
	return MealDescription;
 }

public void setMealDescription(String mealdescription) {
MealDescription = mealdescription;
}

@ElementList(required=false)
private List<POI> POIList ;


public List<POI> getPOIList() {
	return POIList;
 }

public void setPOIList(List<POI> poilist) {
POIList = poilist;
}

}
