package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * @author liujq
 * 附加服务信息
 *
 */
@Root
public class OptionInfo {
	/**
	 * 供应商附加服务编码
	 */
	@Element(required = false)
	private String OptionCode;
	/**
	 * 币种
	 */
	@Element(required = false)
	private String Currency;

	/**
	 * 汇率
	 */
	@Element(required = false)
	private double ExchangeRate;

	/**
	 * 底价
	 */
	@Element(required = false)
	private double CostPrice;

	/**
	 * 份数
	 */
	@Element(required = false)
	private int Quantity;

	/**
	 * 出行人编号列表
	 */
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

	public String getOptionCode() {
		return OptionCode;
	}

	public void setOptionCode(String optionCode) {
		OptionCode = optionCode;
	}


}
