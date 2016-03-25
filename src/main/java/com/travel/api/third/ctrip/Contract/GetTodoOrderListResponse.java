package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.ElementList;

@Root
public class GetTodoOrderListResponse extends ResponseBase {
	@ElementList(required = false)
	private List<Order> TodoOrderList;

	public List<Order> getTodoOrderList() {
		return TodoOrderList;
	}

	public void setTodoOrderList(List<Order> todoorderlist) {
		TodoOrderList = todoorderlist;
	}

	public String GetOrderId() {
		return this.TodoOrderList.get(0).getOrderId();
	}

	public String GetErrorCode() {
		return super.GetErrorCode();
	}
}
