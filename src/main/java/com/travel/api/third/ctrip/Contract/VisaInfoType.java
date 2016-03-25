package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root
public class VisaInfoType {
@Element(required=false)
private boolean IsNeedDeposit ;


public boolean getIsNeedDeposit() {
	return IsNeedDeposit;
 }

public void setIsNeedDeposit(boolean isneeddeposit) {
IsNeedDeposit = isneeddeposit;
}

@Element(required=false)
private VisaDeliveryAddressType VisaDeliveryAddress ;


public VisaDeliveryAddressType getVisaDeliveryAddress() {
	return VisaDeliveryAddress;
 }

public void setVisaDeliveryAddress(VisaDeliveryAddressType visadeliveryaddress) {
VisaDeliveryAddress = visadeliveryaddress;
}

@ElementList(required=false)
private List<Visa> VisaList ;


public List<Visa> getVisaList() {
	return VisaList;
 }

public void setVisaList(List<Visa> visalist) {
VisaList = visalist;
}

}
