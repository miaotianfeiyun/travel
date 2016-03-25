package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root(name = "UpdateProductPriceRequest")
public class UpdateProductPriceRequest  extends RequestBase  {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorproductcode) {
VendorProductCode = vendorproductcode;
}

@ElementList(required=false)
private List<Price> PriceList ;


public List<Price> getPriceList() {
	return PriceList;
 }

public void setPriceList(List<Price> pricelist) {
PriceList = pricelist;
}

}
