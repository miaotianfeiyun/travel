package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: TrainTicketsDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class TrainTicketsDetail {
	 /** 
	* 必填 火车票类型：0-往程 ，1：去程 ，2：回程，3：中间段
	*/ 
	private int trainTicketsType;
	 /** 
	* 坐席类型：0：----- ，1：动车一等座 2：动车二等座 3：硬座 4：软座 5：硬卧 5：软卧 7：高铁 8：城际列车一等座 9 城际列车2等座
	*/ 
	private int trainSiteType;
	
	public int getTrainTicketsType() {
		return trainTicketsType;
	}
	public void setTrainTicketsType(int trainTicketsType) {
		this.trainTicketsType = trainTicketsType;
	}
	public int getTrainSiteType() {
		return trainSiteType;
	}
	public void setTrainSiteType(int trainSiteType) {
		this.trainSiteType = trainSiteType;
	}

}
