package com.travel.api.third.tuniu.API.core.group_date_price;

/** 
 * <p>Title: DatePriceDetail.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.group_date_price</p>  
 * <p>Description:团期价格信息</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class DatePriceDetail {
	private String schemeId;//	Varchar(64)	否	Sheme0001	为空时表示对基础方案操作，否则，操作相应升级方案
	private String scheduleId;//	Varchar(256)	否	schedule	存在多行程，供应商维护的行程编号，为空表示默认行程
	private double agencyBudget;//	int	是	1000	成人同行价
	private double agencyBudgetChild;//	int	否	500	儿童同行价。当不支持儿童出行时，此值无效
	private int excludeChild;//	int	是	1	是否支持儿童出行：0=>不支持;1=>支持
	private int roomAddBudget;//	int	否	100	全程单房差
	private int roomGapFlag;//	int	是	1	是否预付全程单房差：0=>否;1=>是
	private int aheadDate;//	int	是	4	报名开始提前天数
	private int deadlineDate;//	int	是	3	报名截止提前-天
	private int deadlineHour;//	int	是	18	报名截止提前-时
	private int promoFlag;//	int	是	1	是否促销：0=>不是促销;1=>促销
	private int setGroupFlag;//	int	是	1	是否铁定成团：0=>不是;1=>是
	private int stuffEndDate;//	int	否	5	材料提交时间截止
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public double getAgencyBudget() {
		return agencyBudget;
	}
	public void setAgencyBudget(double agencyBudget) {
		this.agencyBudget = agencyBudget;
	}
	public double getAgencyBudgetChild() {
		return agencyBudgetChild;
	}
	public void setAgencyBudgetChild(double agencyBudgetChild) {
		this.agencyBudgetChild = agencyBudgetChild;
	}
	public int getExcludeChild() {
		return excludeChild;
	}
	public void setExcludeChild(int excludeChild) {
		this.excludeChild = excludeChild;
	}
	public int getRoomAddBudget() {
		return roomAddBudget;
	}
	public void setRoomAddBudget(int roomAddBudget) {
		this.roomAddBudget = roomAddBudget;
	}
	public int getRoomGapFlag() {
		return roomGapFlag;
	}
	public void setRoomGapFlag(int roomGapFlag) {
		this.roomGapFlag = roomGapFlag;
	}
	public int getAheadDate() {
		return aheadDate;
	}
	public void setAheadDate(int aheadDate) {
		this.aheadDate = aheadDate;
	}
	public int getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(int deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public int getDeadlineHour() {
		return deadlineHour;
	}
	public void setDeadlineHour(int deadlineHour) {
		this.deadlineHour = deadlineHour;
	}
	public int getPromoFlag() {
		return promoFlag;
	}
	public void setPromoFlag(int promoFlag) {
		this.promoFlag = promoFlag;
	}
	public int getSetGroupFlag() {
		return setGroupFlag;
	}
	public void setSetGroupFlag(int setGroupFlag) {
		this.setGroupFlag = setGroupFlag;
	}
	public int getStuffEndDate() {
		return stuffEndDate;
	}
	public void setStuffEndDate(int stuffEndDate) {
		this.stuffEndDate = stuffEndDate;
	}
	
}
