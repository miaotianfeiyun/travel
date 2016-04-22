package com.travel.api.common.order;

import java.util.List;

import com.travel.api.common.base.ClientBase;
import com.travel.api.common.base.ThirdOTA;
import com.travel.api.common.order.base.OrderOperateType;
import com.travel.api.common.util.HttpTookit;
import com.travel.api.common.util.JsonUtil;
import com.travel.api.common.util.Sign;
/** 
 * <p>Title: OrderClient.java</p>
 * <p>Package Name: com.travel.api.common.order</p>  
 * <p>Description:TODO </p> 
 * @author liujq
 * @date  :2016年4月11日 
 * @version :1.0
 */

public class OrderClient extends ClientBase{
	/** 
	* @Fields token : 认证标识
	* @date 2016年3月21日 上午11:11:13 
	*/ 
	private String token;
	/** 
	* @Fields thirdOTAList : 第三方平台合作key和secret列表
	* @date 2016年3月21日 下午2:03:41 
	*/ 
	private List<ThirdOTA> thirdOTAList;
	/**
	 * 第三方订单编号
	 */
	private String thirdOrderId ;
	
	/**
	 * 供应商系统订单ID
	 */
	private String OrderId ;
	
	/**
	 * 消息编号，该值为订单信息中的消息编号 Order > MessageId。
	 */
	private String MessageId ;
	/**
	 * 拒绝原因
	 */
	private String Reason;
	/**
	 * 操作类型
	 */
	private OrderOperateType operateType;
	/** 
	* @Fields timeStamp : 时间戳
	* @date 2016年4月5日 下午4:05:10 
	*/ 
	private String timeStamp;
	
	
	public String invoke(OrderClient client,String host){
		client.setToken(Sign.signature(JsonUtil.toJson(client),getAppKey(), getAppSecret()));
		return HttpTookit.doPostByStream(host+"/travel"+orderDealUrl, JsonUtil.toJson(client), HttpTookit.CHARSET,"application/json");
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public OrderOperateType getOperateType() {
		return operateType;
	}

	public void setOperateType(OrderOperateType operateType) {
		this.operateType = operateType;
	}

	public String getThirdOrderId() {
		return thirdOrderId;
	}

	public void setThirdOrderId(String thirdOrderId) {
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

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public List<ThirdOTA> getThirdOTAList() {
		return thirdOTAList;
	}

	public void setThirdOTAList(List<ThirdOTA> thirdOTAList) {
		this.thirdOTAList = thirdOTAList;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
