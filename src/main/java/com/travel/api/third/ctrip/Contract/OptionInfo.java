package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root
public class OptionInfo {
	@Element(required = false)
	private String VendorOptionCode;
	@Element(required = false)
	private String Currency;

	@Element(required = false)
	private double ExchangeRate;

	@Element(required = false)
	private double CostPrice;

	@Element(required = false)
	private int Quantity;

	@ElementList(required = false)
	private List<String> TravelerIdList;

	public double getExchangeRate() {
		return ExchangeRate;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public void setExchangeRate(double exchangerate) {
		ExchangeRate = exchangerate;
	}

	public double getCostPrice() {
		return CostPrice;
	}

	public void setCostPrice(double costprice) {
		CostPrice = costprice;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public List<String> getTravelerIdList() {
		return TravelerIdList;
	}

	public void setTravelerIdList(List<String> traveleridlist) {
		TravelerIdList = traveleridlist;
	}

	public String getVendorOptionCode() {
		return VendorOptionCode;
	}

	public void setVendorOptionCode(String vendorOptionCode) {
		VendorOptionCode = vendorOptionCode;
	}

}
