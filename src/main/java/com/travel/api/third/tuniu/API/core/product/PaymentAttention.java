package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: PaymentAttention.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:支付提示信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class PaymentAttention {
	private int type;//	Integer	是	0	类型：:0：为了确保您能够按时出行，产品确认后请在？小时内付款，同时请按要求尽快提供出游所需的材料并签订出境旅游合同。，1：为了确保您能够按时出行，产品确认后请在？小时内付预付款签订报名意向书，同时请按要求尽快提供出游所需的材料，并于出团前5个工作日交齐尾款并签订出境旅游合同。2：预订时请告之您的出游人数、出发日期、住宿、用餐标准、以及您的特殊需求。,0：不包含，1：包含
	private int hourLimit;//	Integer	否	0	时间限制，当type不为2是存在
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getHourLimit() {
		return hourLimit;
	}
	public void setHourLimit(int hourLimit) {
		this.hourLimit = hourLimit;
	}
	
}
