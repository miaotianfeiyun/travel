package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: BudgetIncludeInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:费用包含 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class BudgetIncludeInfo {
	private TrafficDetail trafficInfo;//		否		费用包含的交通信息
	private InnerTrafficInfo innerTrafficInfo	;//	否		费用包含的小交通信息
	private VisaExplain visaExplain	;//	否		费用包含的签证，当产品类型为出境时此值存在
	private LiveDetail liveInfo	;//	否		费用包含住宿信息
	private MealDetail mealInfo	;//	否		费用包含用餐信息用餐支持：中式餐或自助餐或特色餐，自由活动期间用餐请自理；如因自身原因放弃用餐，则餐费不退这个条件 ，则存在此字段
	private int ticketFlag	;//Integer	;//是	0	是否包含门票：0：不包含，1：包含
	private String ticketRemark;//	Varchar(256)	否		门票说明，包含门票是此值存在
	private GuideDetail guideInfo;//	GuideDetail;//	否		费用包含的导服信息
	private ChildStdDetail childStdInfo;//	ChildStdDetail	否		费用包含的儿童价标准
	private TipDetail tipInfo	;//TipDetail	否		费用包含的小费信息
	private String presentInfo	;//Varchar(256)	否		费用包含的赠送信息
	private String otherInfo	;//Varchar(256)	否		费用包含的其他信息
	public TrafficDetail getTrafficInfo() {
		return trafficInfo;
	}
	public void setTrafficInfo(TrafficDetail trafficInfo) {
		this.trafficInfo = trafficInfo;
	}
	public InnerTrafficInfo getInnerTrafficInfo() {
		return innerTrafficInfo;
	}
	public void setInnerTrafficInfo(InnerTrafficInfo innerTrafficInfo) {
		this.innerTrafficInfo = innerTrafficInfo;
	}
	public VisaExplain getVisaExplain() {
		return visaExplain;
	}
	public void setVisaExplain(VisaExplain visaExplain) {
		this.visaExplain = visaExplain;
	}
	public LiveDetail getLiveInfo() {
		return liveInfo;
	}
	public void setLiveInfo(LiveDetail liveInfo) {
		this.liveInfo = liveInfo;
	}
	public MealDetail getMealInfo() {
		return mealInfo;
	}
	public void setMealInfo(MealDetail mealInfo) {
		this.mealInfo = mealInfo;
	}
	public int getTicketFlag() {
		return ticketFlag;
	}
	public void setTicketFlag(int ticketFlag) {
		this.ticketFlag = ticketFlag;
	}
	public String getTicketRemark() {
		return ticketRemark;
	}
	public void setTicketRemark(String ticketRemark) {
		this.ticketRemark = ticketRemark;
	}
	public GuideDetail getGuideInfo() {
		return guideInfo;
	}
	public void setGuideInfo(GuideDetail guideInfo) {
		this.guideInfo = guideInfo;
	}
	public ChildStdDetail getChildStdInfo() {
		return childStdInfo;
	}
	public void setChildStdInfo(ChildStdDetail childStdInfo) {
		this.childStdInfo = childStdInfo;
	}
	public TipDetail getTipInfo() {
		return tipInfo;
	}
	public void setTipInfo(TipDetail tipInfo) {
		this.tipInfo = tipInfo;
	}
	public String getPresentInfo() {
		return presentInfo;
	}
	public void setPresentInfo(String presentInfo) {
		this.presentInfo = presentInfo;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	
}
