package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Visa")
public class Visa {
@Element(required=false)
private String VendorVisaCode ;


public String getVendorVisaCode() {
	return VendorVisaCode;
 }

public void setVendorVisaCode(String vendorvisacode) {
VendorVisaCode = vendorvisacode;
}

@Element(required=false)
private String VisaName ;


public String getVisaName() {
	return VisaName;
 }

public void setVisaName(String visaname) {
VisaName = visaname;
}

}
