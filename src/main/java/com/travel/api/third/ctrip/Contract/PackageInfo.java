package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

/**
 * @author liujq
 * 套餐信息
 *
 */
@Root
public class PackageInfo {
	/**
	 * 供应商套餐编码 如果是基础套餐则为空
	 */
	@Element(required=false)
	private String VendorPackageCode;

	/**
	 * 币种
	 */
	@Element(required=false)
	private String Currency;

	/**
	 * 汇率
	 */
	@Element(required=false)
	private double ExchangeRate;

	/**
	 * 成人份数
	 */
	@Element(required=false)
	private int AdultQuantity;

	/**
	 * 成人底价	
	 */
	@Element(required=false)
	private double AdultCostPrice;

	/**
	 * 儿童份数
	 */
	@Element(required=false)
	private int ChildQuantity;

	/**
	 * 儿童底价
	 */
	@Element(required=false)
	private double ChildCostPrice;

	/**
	 * 单房差份数
	 */
	@Element(required=false)
	private int SinglePersonQuantity;

	/**
	 * 单房差底价
	 */
	@Element(required=false)
	private double SinglePersonCostPrice;

	/**
	 * 婴儿份数
	 */
	@Element(required=false)
	private int InfantQuantity;


	public String getVendorPackageCode() {
		return VendorPackageCode;
	}

	public void setVendorPackageCode(String vendorPackageCode) {
		VendorPackageCode = vendorPackageCode;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public double getExchangeRate() {
		return ExchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		ExchangeRate = exchangeRate;
	}

	public int getAdultQuantity() {
		return AdultQuantity;
	}

	public void setAdultQuantity(int adultQuantity) {
		AdultQuantity = adultQuantity;
	}

	public double getAdultCostPrice() {
		return AdultCostPrice;
	}

	public void setAdultCostPrice(double adultCostPrice) {
		AdultCostPrice = adultCostPrice;
	}

	public int getChildQuantity() {
		return ChildQuantity;
	}

	public void setChildQuantity(int childQuantity) {
		ChildQuantity = childQuantity;
	}

	public double getChildCostPrice() {
		return ChildCostPrice;
	}

	public void setChildCostPrice(double childCostPrice) {
		ChildCostPrice = childCostPrice;
	}

	public int getSinglePersonQuantity() {
		return SinglePersonQuantity;
	}

	public void setSinglePersonQuantity(int singlePersonQuantity) {
		SinglePersonQuantity = singlePersonQuantity;
	}

	public double getSinglePersonCostPrice() {
		return SinglePersonCostPrice;
	}

	public void setSinglePersonCostPrice(double singlePersonCostPrice) {
		SinglePersonCostPrice = singlePersonCostPrice;
	}

	public int getInfantQuantity() {
		return InfantQuantity;
	}

	public void setInfantQuantity(int infantQuantity) {
		InfantQuantity = infantQuantity;
	}

}
