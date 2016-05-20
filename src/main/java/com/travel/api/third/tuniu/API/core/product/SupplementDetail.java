package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: SupplementDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:补充信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class SupplementDetail {
	private int upholdFeeFlag;//	Integer	是		是否存在丽江古城维护费80元/人：0不存在，1存在(国内存在)
	private int 	governmentRegulationFlag;//	Integer	是		是否存在海南政府调节金：0不存在，1存在(国内存在) 元/人
	private int 	customsFeeFlag;//	Integer	是		是否存在出入境个人物品海关征税，超重行李的托运费、保管费，0：不存在，1：存在(出境存在)
	private int 	extraCostFlag;//	Integer	是		是否存在港澳通行证置证费：0：不存在，1：存在
	private int 	roundTripPermit;//	Integer	是		因交通延阻、战争、政变、罢工、天气、飞机机器故障、航班取消或更改时间等不可抗力原因所引致的额外费用，0：不存在，1：存在
	private int 	personalConsumptionFlag;//	Integer	是		酒店内洗衣、理发、电话、传真、收费电视、饮品、烟酒等个人消费，0：不存在，1：存在
	private int 	selfChargeFlag;//	Integer	是		当地参加的自费以及以上“费用包含”中不包含的其它项目0：不存在，1：存在
	public int getUpholdFeeFlag() {
		return upholdFeeFlag;
	}
	public void setUpholdFeeFlag(int upholdFeeFlag) {
		this.upholdFeeFlag = upholdFeeFlag;
	}
	public int getGovernmentRegulationFlag() {
		return governmentRegulationFlag;
	}
	public void setGovernmentRegulationFlag(int governmentRegulationFlag) {
		this.governmentRegulationFlag = governmentRegulationFlag;
	}
	public int getCustomsFeeFlag() {
		return customsFeeFlag;
	}
	public void setCustomsFeeFlag(int customsFeeFlag) {
		this.customsFeeFlag = customsFeeFlag;
	}
	public int getExtraCostFlag() {
		return extraCostFlag;
	}
	public void setExtraCostFlag(int extraCostFlag) {
		this.extraCostFlag = extraCostFlag;
	}
	public int getRoundTripPermit() {
		return roundTripPermit;
	}
	public void setRoundTripPermit(int roundTripPermit) {
		this.roundTripPermit = roundTripPermit;
	}
	public int getPersonalConsumptionFlag() {
		return personalConsumptionFlag;
	}
	public void setPersonalConsumptionFlag(int personalConsumptionFlag) {
		this.personalConsumptionFlag = personalConsumptionFlag;
	}
	public int getSelfChargeFlag() {
		return selfChargeFlag;
	}
	public void setSelfChargeFlag(int selfChargeFlag) {
		this.selfChargeFlag = selfChargeFlag;
	}
	
}
