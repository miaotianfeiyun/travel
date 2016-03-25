package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "BeginSellingRequest")
public class BeginSellingRequest  extends RequestBase  {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorproductcode) {
VendorProductCode = vendorproductcode;
}

@ElementList(required=false)
private List<BeginSelling> SellingList ;


public List<BeginSelling> getSellingList() {
	return SellingList;
 }

public void setSellingList(List<BeginSelling> sellinglist) {
SellingList = sellinglist;
}

}
