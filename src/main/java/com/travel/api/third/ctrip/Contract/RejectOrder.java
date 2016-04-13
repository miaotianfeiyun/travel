package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;

/**
 * @author liujq
 *  拒绝订单
 */
public class RejectOrder {
	/**
	 * 第三方订单编号
	 */
	@Element(required = false)
	private String thirdOrderId;
	/**
	 * 消息编号，该值为订单信息中的消息编号 Order > MessageId。
	 */
	@Element(required = false)
	private String MessageId;
	/**
	 * 拒绝原因
	 */
	@Element(required = false)
	private String Reason;


	public String getThirdOrderId() {
		return thirdOrderId;
	}
	public void setThirdOrderId(String thirdOrderId) {
		this.thirdOrderId = thirdOrderId;
	}
	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getMessageId() {
		return MessageId;
	}

	public void setMessageId(String messageid) {
		MessageId = messageid;
	}
}
