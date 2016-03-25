package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root(name = "UpdateProductOptionRequest")
public class UpdateProductOptionRequest  extends RequestBase  {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorproductcode) {
VendorProductCode = vendorproductcode;
}

@ElementList(required=false)
private List<Option> OptionList ;


public List<Option> getOptionList() {
	return OptionList;
 }

public void setOptionList(List<Option> optionlist) {
OptionList = optionlist;
}

}
