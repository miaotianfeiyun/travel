package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CreateOrderRequest")
public class CreateOrderRequest extends RequestBase {
	@Element(required = false)
	private String Token;

	@Element(required = false)
	private Order Order;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public Order getOrder() {
		return Order;
	}

	public void setOrder(Order order) {
		Order = order;
	}

}
