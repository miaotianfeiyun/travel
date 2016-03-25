package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "StopSellingRequest")
public class StopSellingRequest  extends RequestBase  {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorproductcode) {
VendorProductCode = vendorproductcode;
}

@ElementList(required=false)
private List<StopSelling> SellingList ;


public List<StopSelling> getSellingList() {
	return SellingList;
 }

public void setSellingList(List<StopSelling> sellinglist) {
SellingList = sellinglist;
}

}
