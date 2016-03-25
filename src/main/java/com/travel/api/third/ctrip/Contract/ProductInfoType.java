package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class ProductInfoType {
@Element(required=false)
private String TourType ;


public String getTourType() {
	return TourType;
 }

public void setTourType(String tourtype) {
TourType = tourtype;
}

@Element(required=false)
private String VendorProductName ;


public String getVendorProductName() {
	return VendorProductName;
 }

public void setVendorProductName(String vendorproductname) {
VendorProductName = vendorproductname;
}

@Element(required=false)
private String BrandName ;


public String getBrandName() {
	return BrandName;
 }

public void setBrandName(String brandname) {
BrandName = brandname;
}

@Element(required=false)
private String ProductRecommend ;


public String getProductRecommend() {
	return ProductRecommend;
 }

public void setProductRecommend(String productrecommend) {
ProductRecommend = productrecommend;
}

@Element(required=false)
private String DescriptionToCtripOperator ;


public String getDescriptionToCtripOperator() {
	return DescriptionToCtripOperator;
 }

public void setDescriptionToCtripOperator(String descriptiontoctripoperator) {
DescriptionToCtripOperator = descriptiontoctripoperator;
}

@Element(required=false)
private int TravelDays ;


public int getTravelDays() {
	return TravelDays;
 }

public void setTravelDays(int traveldays) {
TravelDays = traveldays;
}

@Element(required=false)
private String DepartureCityName ;


public String getDepartureCityName() {
	return DepartureCityName;
 }

public void setDepartureCityName(String departurecityname) {
DepartureCityName = departurecityname;
}

@Element(required=false)
private String ArrivalCityName ;


public String getArrivalCityName() {
	return ArrivalCityName;
 }

public void setArrivalCityName(String arrivalcityname) {
ArrivalCityName = arrivalcityname;
}

@Element(required=false)
private String TransportationType ;


public String getTransportationType() {
	return TransportationType;
 }

public void setTransportationType(String transportationtype) {
TransportationType = transportationtype;
}

@Element(required=false)
private boolean IsNeedIDCard ;


public boolean getIsNeedIDCard() {
	return IsNeedIDCard;
 }

public void setIsNeedIDCard(boolean isneedidcard) {
IsNeedIDCard = isneedidcard;
}

}
