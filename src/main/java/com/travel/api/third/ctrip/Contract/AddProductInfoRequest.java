package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root(name = "AddProductInfoRequest")
public class AddProductInfoRequest  extends RequestBase  {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorproductcode) {
VendorProductCode = vendorproductcode;
}

@Element(required=false)
private ProductInfoType ProductInfo ;


public ProductInfoType getProductInfo() {
	return ProductInfo;
 }

public void setProductInfo(ProductInfoType productinfo) {
ProductInfo = productinfo;
}

@Element(required=false)
private BookingInfo BookingInfo ;


public BookingInfo getBookingInfo() {
	return BookingInfo;
 }

public void setBookingInfo(BookingInfo bookinginfo) {
BookingInfo = bookinginfo;
}

@Element(required=false)
private VisaInfoType VisaInfo ;


public VisaInfoType getVisaInfo() {
	return VisaInfo;
 }

public void setVisaInfo(VisaInfoType visainfo) {
VisaInfo = visainfo;
}

@ElementList(required=false)
private List<ProductDescription> ProductDescriptionList ;


public List<ProductDescription> getProductDescriptionList() {
	return ProductDescriptionList;
 }

public void setProductDescriptionList(List<ProductDescription> productdescriptionlist) {
ProductDescriptionList = productdescriptionlist;
}

@ElementList(required=false)
private List<ItineraryDay> ItineraryList ;


public List<ItineraryDay> getItineraryList() {
	return ItineraryList;
 }

public void setItineraryList(List<ItineraryDay> itinerarylist) {
ItineraryList = itinerarylist;
}

@Element(required=false)
private BreachClause BreachClause ;


public BreachClause getBreachClause() {
	return BreachClause;
 }

public void setBreachClause(BreachClause breachclause) {
BreachClause = breachclause;
}

}
