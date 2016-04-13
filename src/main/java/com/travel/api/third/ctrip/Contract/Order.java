package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root
public class Order {
	/**
	 * 携程订单编号
	 */
	@Element(required = false)
	private String OrderId;

	@Element(required = false)
	private OrderAction Action;
	
	/**
	 * 供应商产品编码
	 */
	@Element(required = false)
	private String ProductCode;
	
	/**
	 * 出发日期
	 */
	@Element(required = false)
	private String DepartureDate;
	
	/**
	 * 订单信息 
	 */
	@Element(required = false)
	private OrderInfo OrderInfo;
	
	/**
	 * 订单的修改信息
	 */
	@ElementList(required = false)
	private List<Change> ChangeList;
	
	/**
	 * 消息Id
	 */
	@Element(required = false)
	private String MessageId;
	
	public OrderAction getAction() {
		return Action;
	}

	public void setAction(OrderAction action) {
		Action = action;
	}
	public String getDepartureDate() {
		return DepartureDate;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public void setDepartureDate(String departuredate) {
		DepartureDate = departuredate;
	}

	public OrderInfo getOrderInfo() {
		return OrderInfo;
	}

	public void setOrderInfo(OrderInfo orderinfo) {
		OrderInfo = orderinfo;
	}

	public List<Change> getChangeList() {
		return ChangeList;
	}

	public void setChangeList(List<Change> changelist) {
		ChangeList = changelist;
	}


	public String getMessageId() {
		return MessageId;
	}

	public void setMessageId(String messageid) {
		MessageId = messageid;
	}

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

}
