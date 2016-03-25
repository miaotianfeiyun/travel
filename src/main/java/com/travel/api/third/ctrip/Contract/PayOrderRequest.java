package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "PayOrderRequest")
public class PayOrderRequest  extends RequestBase  {
@Element(required=false)
private String Token ;


public String getToken() {
	return Token;
 }

public void setToken(String token) {
Token = token;
}

@Element(required=false)
private Order Order ;


public Order getOrder() {
	return Order;
 }

public void setOrder(Order order) {
Order = order;
}

}
