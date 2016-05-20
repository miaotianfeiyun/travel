package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: AttentionInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:预定须知</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class AttentionInfo {
	private int selfDrivingFlag;//	Integer	是		是否自驾游手动编写内容，0：否，1：是
	private String selfDrivingRemark;//	Varchar(1024)	否		自驾游手动编写的内容，仅在selfDrivingFlag为1时，此字段存在意义
	private PaymentAttention paymentAttention;//	PaymentAttention	否		（出境）付款的预定须知
	private int groupCancelFlag;//	Integer	是	0	（出境）是否在此团收客人数不足？人时，取消行程：0：否，1：是
	private int groupCancelNumLimit;//	Integer	否		（出境）取消行程的最小人数限制，仅当允许取消行程时，此值有意义
	private int groupCancelDayLimit;//	Integer	否		（出境）取消行程的通知提前天数，仅当允许取消行程时，此值有意义
	private int leaveTeamFlag;//	Integer	是		（出境）团队游览中是否允许擅自离队：0：允许，1：不允许
	private int liquidatedDamagesFlag;//	Integer	否		（出境）擅自离队是否需要支付违约金，0：否，1：是，尽在不允许擅自离队时存在意义
	private int liquidatedCost;//	Integer	否		（出境）需要支付的违约金金额，仅在需要支付违约金时有意义
	private int saleNoteFlag;//	Integer	是	0	（出境）是否包含销售说明：0：不包含，1：包含
	private int allowPeopleType;//	Integer	是	0	（出境）允许人群：0：全部，1：只接受持各地签发的中国大陆因私护照客人，不接受港澳台及外籍客人预订2：只接受持各地签发的港澳通行证客人，不接受港澳台及外籍客人预订
	private int selfVisaNoteFlag;//	Integer	是	0	（出境）自备签证说明：0：不存在，1：存在
	private String[] extraNoteList;//	Varchar[];//	否		附加提示
	private int timeDelayNoteFlag;//	Integer	是	0	（出境）因甲方原因发生拒签、延时交签造成本次出境行程变更或取消的，乙方不承担违约责任，甲方需承担申办 签证费用____/人 是否存在，0：不存在，1：存在
	private int bookingCannelGroupNoteFlag;//	Integer	是	0	（出境）出签前，顾客取消行程说明是否存在：0：不存在，1：存在
	private int orderCannelGroupNoteFlag;//	Integer	是	0	（出境）出签后，顾客取消行程说明是否存在：0：不存在，1：存在
	private int airTicketNoteFlag;//	Integer	是	0	（出境）机票说明是否存在：0：不存在，1：存在
	private int consumeBlameNoteFlag;//	Integer	是	0	（出境）甲方原因无法出游乙方免责说明是否存在：0：不存在，1：存在
	private int specialNoteFlag;//	Integer	是	0	（出境）特别提醒说明是否存在：0：不存在，1：存在
	private int flightNoteFlag;//	Integer	是	0	（出境）航班信息说明是否存在：0：不存在，1：存在
	private int guaranteeGoldNoteFlag;//	Integer	是	0	（出境）担保金说明是否存在：0：不存在，1：存在
	private LiveAttentionDetail liveAttentionInfo;//	LiveAttentionDetail	否		（非出境）住宿说明
	private int mealAttentionFlag;//	Integer	是	0	是否包含用餐说明：0：不包含，1：包含
	private int foodNum;//	Integer	否	0	？道菜，仅当包含用餐说明是存在
	private int differenceAttentionFlag	;//Integer	是	0	（非出境）是否存在差价说明：0：不存在，1：存在 备注：存在插件说明，则必须支持1.	（1）如遇国家政策性调整门票、交通价格等，按调整后的实际价格结算。2.	（2）赠送项目因航班、天气等不可抗因素导致不能赠送的，费用不退。3.	这两个必要因素
	private int differenceAttentionType;//	Integer	否		（非出境）差价说明：0：景点门票为旅行社折扣价，如持优待证件（如老年证、军官证、教师证等）产生折扣退费的，按实际差额退还，1：云南当地景点实行套票制，如持优待证件（如老年证、军官证、教师证等）或没有游览完行程景点，产生差价不退2：本线路价格为团队行程综合旅游报价，持有任何优惠证件的游客均不再享受景区门票的优惠政策。仅在包含差价说明是存在意义
	private String operateAttention	;//Varchar(5000)	否		产品注意事项
	private String warnAttention;//	Varchar(5000)	否		温馨提示
	private String highRiskTips;//	Varchar(64)	否	0,1,2,3	高危项提示,： 0，漂流1，浮潜3，高原4，快艇5，潜水6，滑雪 多个以逗号分割
	public int getSelfDrivingFlag() {
		return selfDrivingFlag;
	}
	public void setSelfDrivingFlag(int selfDrivingFlag) {
		this.selfDrivingFlag = selfDrivingFlag;
	}
	public String getSelfDrivingRemark() {
		return selfDrivingRemark;
	}
	public void setSelfDrivingRemark(String selfDrivingRemark) {
		this.selfDrivingRemark = selfDrivingRemark;
	}
	public PaymentAttention getPaymentAttention() {
		return paymentAttention;
	}
	public void setPaymentAttention(PaymentAttention paymentAttention) {
		this.paymentAttention = paymentAttention;
	}
	public int getGroupCancelFlag() {
		return groupCancelFlag;
	}
	public void setGroupCancelFlag(int groupCancelFlag) {
		this.groupCancelFlag = groupCancelFlag;
	}
	public int getGroupCancelNumLimit() {
		return groupCancelNumLimit;
	}
	public void setGroupCancelNumLimit(int groupCancelNumLimit) {
		this.groupCancelNumLimit = groupCancelNumLimit;
	}
	public int getGroupCancelDayLimit() {
		return groupCancelDayLimit;
	}
	public void setGroupCancelDayLimit(int groupCancelDayLimit) {
		this.groupCancelDayLimit = groupCancelDayLimit;
	}
	public int getLeaveTeamFlag() {
		return leaveTeamFlag;
	}
	public void setLeaveTeamFlag(int leaveTeamFlag) {
		this.leaveTeamFlag = leaveTeamFlag;
	}
	public int getLiquidatedDamagesFlag() {
		return liquidatedDamagesFlag;
	}
	public void setLiquidatedDamagesFlag(int liquidatedDamagesFlag) {
		this.liquidatedDamagesFlag = liquidatedDamagesFlag;
	}
	public int getLiquidatedCost() {
		return liquidatedCost;
	}
	public void setLiquidatedCost(int liquidatedCost) {
		this.liquidatedCost = liquidatedCost;
	}
	public int getSaleNoteFlag() {
		return saleNoteFlag;
	}
	public void setSaleNoteFlag(int saleNoteFlag) {
		this.saleNoteFlag = saleNoteFlag;
	}
	public int getAllowPeopleType() {
		return allowPeopleType;
	}
	public void setAllowPeopleType(int allowPeopleType) {
		this.allowPeopleType = allowPeopleType;
	}
	public int getSelfVisaNoteFlag() {
		return selfVisaNoteFlag;
	}
	public void setSelfVisaNoteFlag(int selfVisaNoteFlag) {
		this.selfVisaNoteFlag = selfVisaNoteFlag;
	}
	public String[] getExtraNoteList() {
		return extraNoteList;
	}
	public void setExtraNoteList(String[] extraNoteList) {
		this.extraNoteList = extraNoteList;
	}
	public int getTimeDelayNoteFlag() {
		return timeDelayNoteFlag;
	}
	public void setTimeDelayNoteFlag(int timeDelayNoteFlag) {
		this.timeDelayNoteFlag = timeDelayNoteFlag;
	}
	public int getBookingCannelGroupNoteFlag() {
		return bookingCannelGroupNoteFlag;
	}
	public void setBookingCannelGroupNoteFlag(int bookingCannelGroupNoteFlag) {
		this.bookingCannelGroupNoteFlag = bookingCannelGroupNoteFlag;
	}
	public int getOrderCannelGroupNoteFlag() {
		return orderCannelGroupNoteFlag;
	}
	public void setOrderCannelGroupNoteFlag(int orderCannelGroupNoteFlag) {
		this.orderCannelGroupNoteFlag = orderCannelGroupNoteFlag;
	}
	public int getAirTicketNoteFlag() {
		return airTicketNoteFlag;
	}
	public void setAirTicketNoteFlag(int airTicketNoteFlag) {
		this.airTicketNoteFlag = airTicketNoteFlag;
	}
	public int getConsumeBlameNoteFlag() {
		return consumeBlameNoteFlag;
	}
	public void setConsumeBlameNoteFlag(int consumeBlameNoteFlag) {
		this.consumeBlameNoteFlag = consumeBlameNoteFlag;
	}
	public int getSpecialNoteFlag() {
		return specialNoteFlag;
	}
	public void setSpecialNoteFlag(int specialNoteFlag) {
		this.specialNoteFlag = specialNoteFlag;
	}
	public int getFlightNoteFlag() {
		return flightNoteFlag;
	}
	public void setFlightNoteFlag(int flightNoteFlag) {
		this.flightNoteFlag = flightNoteFlag;
	}
	public int getGuaranteeGoldNoteFlag() {
		return guaranteeGoldNoteFlag;
	}
	public void setGuaranteeGoldNoteFlag(int guaranteeGoldNoteFlag) {
		this.guaranteeGoldNoteFlag = guaranteeGoldNoteFlag;
	}
	public LiveAttentionDetail getLiveAttentionInfo() {
		return liveAttentionInfo;
	}
	public void setLiveAttentionInfo(LiveAttentionDetail liveAttentionInfo) {
		this.liveAttentionInfo = liveAttentionInfo;
	}
	public int getMealAttentionFlag() {
		return mealAttentionFlag;
	}
	public void setMealAttentionFlag(int mealAttentionFlag) {
		this.mealAttentionFlag = mealAttentionFlag;
	}
	public int getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}
	public int getDifferenceAttentionFlag() {
		return differenceAttentionFlag;
	}
	public void setDifferenceAttentionFlag(int differenceAttentionFlag) {
		this.differenceAttentionFlag = differenceAttentionFlag;
	}
	public int getDifferenceAttentionType() {
		return differenceAttentionType;
	}
	public void setDifferenceAttentionType(int differenceAttentionType) {
		this.differenceAttentionType = differenceAttentionType;
	}
	public String getOperateAttention() {
		return operateAttention;
	}
	public void setOperateAttention(String operateAttention) {
		this.operateAttention = operateAttention;
	}
	public String getWarnAttention() {
		return warnAttention;
	}
	public void setWarnAttention(String warnAttention) {
		this.warnAttention = warnAttention;
	}
	public String getHighRiskTips() {
		return highRiskTips;
	}
	public void setHighRiskTips(String highRiskTips) {
		this.highRiskTips = highRiskTips;
	}
	
}
