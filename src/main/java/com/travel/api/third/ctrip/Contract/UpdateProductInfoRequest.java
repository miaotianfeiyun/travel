package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "UpdateProductInfoRequest")
public class UpdateProductInfoRequest  extends RequestBase  {
	
@Element(required=false)
private String VendorProductCode ;

@Element(required=false)
private UpdateProductInfoType ProductInfo ;

@Element(required=false)
private BookingInfo BookingInfo ;

@Element(required=false)
private VisaInfoType VisaInfo ;

@ElementList(required=false)
private List<ProductDescription> ProductDescriptionList ;

@ElementList(required=false)
private List<ItineraryDay> ItineraryList ;

@Element(required=false)
private BreachClause BreachClause ;

public String getVendorProductCode() {
	return VendorProductCode;
}

public void setVendorProductCode(String vendorProductCode) {
	VendorProductCode = vendorProductCode;
}

public UpdateProductInfoType getProductInfo() {
	return ProductInfo;
}

public void setProductInfo(UpdateProductInfoType productInfo) {
	ProductInfo = productInfo;
}

public BookingInfo getBookingInfo() {
	return BookingInfo;
}

public void setBookingInfo(BookingInfo bookingInfo) {
	BookingInfo = bookingInfo;
}

public VisaInfoType getVisaInfo() {
	return VisaInfo;
}

public void setVisaInfo(VisaInfoType visaInfo) {
	VisaInfo = visaInfo;
}

public List<ProductDescription> getProductDescriptionList() {
	return ProductDescriptionList;
}

public void setProductDescriptionList(
		List<ProductDescription> productDescriptionList) {
	ProductDescriptionList = productDescriptionList;
}

public List<ItineraryDay> getItineraryList() {
	return ItineraryList;
}

public void setItineraryList(List<ItineraryDay> itineraryList) {
	ItineraryList = itineraryList;
}

public BreachClause getBreachClause() {
	return BreachClause;
}

public void setBreachClause(BreachClause breachClause) {
	BreachClause = breachClause;
}

}
