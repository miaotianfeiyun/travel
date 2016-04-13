package com.travel.api.common.order.base;

import org.simpleframework.xml.Element;

/**
 * @author liujq
 *	确认订单
 */
public class ConfirmOrder {

	/**
	 * 第三方订单编号
	 */
	@Element(required=false)
	private long thirdOrderId ;
	
	/**
	 * 供应商系统订单ID
	 */
	@Element(required=false)
	private String OrderId ;
	
	/**
	 * 消息编号，该值为订单信息中的消息编号 Order > MessageId。
	 */
	@Element(required=false)
	private String MessageId ;
	
	public long getThirdOrderId() {
		return thirdOrderId;
	}

	public void setThirdOrderId(long thirdOrderId) {
		this.thirdOrderId = thirdOrderId;
	}

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public String getMessageId() {
		return MessageId;
	}

	public void setMessageId(String messageId) {
		MessageId = messageId;
	}
	


}
