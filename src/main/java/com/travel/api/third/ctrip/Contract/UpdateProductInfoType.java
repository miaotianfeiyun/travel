package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class UpdateProductInfoType {
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
