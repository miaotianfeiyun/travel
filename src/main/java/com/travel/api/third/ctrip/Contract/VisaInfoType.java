package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root
public class VisaInfoType {
	@Element(required = false)
	private boolean IsNeedDeposit;

	@Element(required = false)
	private VisaDeliveryAddressType VisaDeliveryAddress;

	@ElementList(required = false)
	private List<Visa> VisaList;

	public boolean isIsNeedDeposit() {
		return IsNeedDeposit;
	}

	public void setIsNeedDeposit(boolean isNeedDeposit) {
		IsNeedDeposit = isNeedDeposit;
	}

	public VisaDeliveryAddressType getVisaDeliveryAddress() {
		return VisaDeliveryAddress;
	}

	public void setVisaDeliveryAddress(VisaDeliveryAddressType visaDeliveryAddress) {
		VisaDeliveryAddress = visaDeliveryAddress;
	}

	public List<Visa> getVisaList() {
		return VisaList;
	}

	public void setVisaList(List<Visa> visaList) {
		VisaList = visaList;
	}

}
