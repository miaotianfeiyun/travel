package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: SpecialPeopleInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:特殊人群限制信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class SpecialPeopleInfo {
	private int numMinFlag;//	Integer	是		是否存在单订单出游人数少于？人，需现询确认：0：不存在，1：存在
	private int 	numMinValue;//	Integer	否	0	最少人数。存在但订单最小人数限制时存在
	private int 	numMaxFlag;//	Integer	是		是否存在单订单出游人数大于？人，需现询确认：0：不存在，1：存在
	private int 	numMaxValue	;//Integer	否	0	最大人数。存在但订单最大人数限制时存在
	private int 	ageMinFlag;//	Integer	是		是否存在出游人年龄小于？岁（含），不接收：0：不存在，1：存在
	private int 	ageMinValue;//	Integer	否	0	最小年龄。存在出游人年龄最小限制时存在
	private int 	ageMaxFlag;//	Integer	是		是否存在出游人年龄超过？岁（含），不接收：0：不存在，1：存在
	private int 	ageMaxValue;//	Integer	否	0	最大年龄。存在出游人年龄最大限制时存在
	private int 	ageMaxDealFlag;//	Integer	是		是否存在出游人年龄超过？岁（含），需要签署健康协议：0：不存在，1：存在
	private int 	ageMaxDealValue;//	Integer	否	0	年龄。存在出游人年龄最大限制须签署协议时存在
	private int 	ageLimitFlag;//	Integer	是	0	年龄限制，0：无限制，1：存在限制
	private int 	ageMinLimit;//	Integer	否	0	年龄最小限制， 存在年龄限制时有意义
	private int 	ageMaxLimit;//	Integer	否	0	年龄最大限制， 存在年龄限制时有意义
	private int 	allowForeignerFlag;//	Integer	是	0	是否不接受外籍游客：0：是，1：否
	private int 	areaLimitFlag;//	Integer	是		是存在地域限制：0：不存在，1：存在
	private int 	areaLimitType;//	Integer	否	0	0：包含的地域存在限制，1：不包含的地域存在限制；当不存在地域限制时，此值无意义
	private AreaLimitDetail[] areaLimitList;//	AreaLimitDetail[]	否		限制的地域列表
	public int getNumMinFlag() {
		return numMinFlag;
	}
	public void setNumMinFlag(int numMinFlag) {
		this.numMinFlag = numMinFlag;
	}
	public int getNumMinValue() {
		return numMinValue;
	}
	public void setNumMinValue(int numMinValue) {
		this.numMinValue = numMinValue;
	}
	public int getNumMaxFlag() {
		return numMaxFlag;
	}
	public void setNumMaxFlag(int numMaxFlag) {
		this.numMaxFlag = numMaxFlag;
	}
	public int getNumMaxValue() {
		return numMaxValue;
	}
	public void setNumMaxValue(int numMaxValue) {
		this.numMaxValue = numMaxValue;
	}
	public int getAgeMinFlag() {
		return ageMinFlag;
	}
	public void setAgeMinFlag(int ageMinFlag) {
		this.ageMinFlag = ageMinFlag;
	}
	public int getAgeMinValue() {
		return ageMinValue;
	}
	public void setAgeMinValue(int ageMinValue) {
		this.ageMinValue = ageMinValue;
	}
	public int getAgeMaxFlag() {
		return ageMaxFlag;
	}
	public void setAgeMaxFlag(int ageMaxFlag) {
		this.ageMaxFlag = ageMaxFlag;
	}
	public int getAgeMaxValue() {
		return ageMaxValue;
	}
	public void setAgeMaxValue(int ageMaxValue) {
		this.ageMaxValue = ageMaxValue;
	}
	public int getAgeMaxDealFlag() {
		return ageMaxDealFlag;
	}
	public void setAgeMaxDealFlag(int ageMaxDealFlag) {
		this.ageMaxDealFlag = ageMaxDealFlag;
	}
	public int getAgeMaxDealValue() {
		return ageMaxDealValue;
	}
	public void setAgeMaxDealValue(int ageMaxDealValue) {
		this.ageMaxDealValue = ageMaxDealValue;
	}
	public int getAgeLimitFlag() {
		return ageLimitFlag;
	}
	public void setAgeLimitFlag(int ageLimitFlag) {
		this.ageLimitFlag = ageLimitFlag;
	}
	public int getAgeMinLimit() {
		return ageMinLimit;
	}
	public void setAgeMinLimit(int ageMinLimit) {
		this.ageMinLimit = ageMinLimit;
	}
	public int getAgeMaxLimit() {
		return ageMaxLimit;
	}
	public void setAgeMaxLimit(int ageMaxLimit) {
		this.ageMaxLimit = ageMaxLimit;
	}
	public int getAllowForeignerFlag() {
		return allowForeignerFlag;
	}
	public void setAllowForeignerFlag(int allowForeignerFlag) {
		this.allowForeignerFlag = allowForeignerFlag;
	}
	public int getAreaLimitFlag() {
		return areaLimitFlag;
	}
	public void setAreaLimitFlag(int areaLimitFlag) {
		this.areaLimitFlag = areaLimitFlag;
	}
	public int getAreaLimitType() {
		return areaLimitType;
	}
	public void setAreaLimitType(int areaLimitType) {
		this.areaLimitType = areaLimitType;
	}
	public AreaLimitDetail[] getAreaLimitList() {
		return areaLimitList;
	}
	public void setAreaLimitList(AreaLimitDetail[] areaLimitList) {
		this.areaLimitList = areaLimitList;
	}
	
}
