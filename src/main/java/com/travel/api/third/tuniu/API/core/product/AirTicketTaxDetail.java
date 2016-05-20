package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: AirTicketTaxDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:机票税信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class AirTicketTaxDetail {
	private int roundTripFlag	;//Integer	是		往返机票税：0：不存在，1：存在
	private int 	roundTripCost;//	Integer	否	0	当存在往返机票税时的价格 元/人
	private int 	foreignTaxFlag;//	Integer	是		境外机场回程机场税：0：不存在，1：存在
	private int 	foreignTaxCost;//	Integer	否	0	当存在境外机场回程机场税的价格 元/人
	public int getRoundTripFlag() {
		return roundTripFlag;
	}
	public void setRoundTripFlag(int roundTripFlag) {
		this.roundTripFlag = roundTripFlag;
	}
	public int getRoundTripCost() {
		return roundTripCost;
	}
	public void setRoundTripCost(int roundTripCost) {
		this.roundTripCost = roundTripCost;
	}
	public int getForeignTaxFlag() {
		return foreignTaxFlag;
	}
	public void setForeignTaxFlag(int foreignTaxFlag) {
		this.foreignTaxFlag = foreignTaxFlag;
	}
	public int getForeignTaxCost() {
		return foreignTaxCost;
	}
	public void setForeignTaxCost(int foreignTaxCost) {
		this.foreignTaxCost = foreignTaxCost;
	}
	
}
