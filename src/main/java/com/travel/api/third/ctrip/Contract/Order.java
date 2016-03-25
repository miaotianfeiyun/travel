package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root
public class Order {
	@Element(required = false)
	private String OrderId;

	@Element(required = false)
	private OrderAction Action;
	
	@Element(required = false)
	private String VendorProductCode;
	
	@Element(required = false)
	private String DepartureDate;
	
	@Element(required = false)
	private OrderInfo OrderInfo;
	
	@ElementList(required = false)
	private List<Change> ChangeList;
	
	@Element(required = false)
	private String MessageId;
	
	public OrderAction getAction() {
		return Action;
	}

	public void setAction(OrderAction action) {
		Action = action;
	}
	public String getVendorProductCode() {
		return VendorProductCode;
	}

	public void setVendorProductCode(String vendorproductcode) {
		VendorProductCode = vendorproductcode;
	}
	public String getDepartureDate() {
		return DepartureDate;
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
