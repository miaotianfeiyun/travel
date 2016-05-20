package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: BudgetExcludeInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:费用不包含信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class BudgetExcludeInfo {
	private InnerTrafficInfo innerTrafficInfo;//	InnerTrafficInfo	否		费用不包含的小交通信息
	private AirTicketTaxDetail airTicketTax;//	AirTicketTaxDetail	否		机票税信息
	private Endorsement endorsement;//	Endorsement	否		签证/签注信息
	private int roomAddBudgetFlag;//	Integer	是		是否包含单房差：0：不包含，1：包含
	private String roomAddBudgetRemark;//	Varchar(256)	否		单房差说明，仅在包含单房差信息时存在
	private int ticketFlag;//	Integer	是	0	是否包含门票：0：不包含，1：包含
	private String ticketRemark;//	Varchar(256)	否		门票说明，包含门票是此值存在
	private String other;//	Varchar(256)	否		其他信息
	private SupplementDetail supplementDetail;//	SupplementDetail	否		补充信息
	private int accidentInsurance;//	Integer	是		是否存在旅游意外险：0：不存在，1：存在
	public InnerTrafficInfo getInnerTrafficInfo() {
		return innerTrafficInfo;
	}
	public void setInnerTrafficInfo(InnerTrafficInfo innerTrafficInfo) {
		this.innerTrafficInfo = innerTrafficInfo;
	}
	public AirTicketTaxDetail getAirTicketTax() {
		return airTicketTax;
	}
	public void setAirTicketTax(AirTicketTaxDetail airTicketTax) {
		this.airTicketTax = airTicketTax;
	}
	public Endorsement getEndorsement() {
		return endorsement;
	}
	public void setEndorsement(Endorsement endorsement) {
		this.endorsement = endorsement;
	}
	public int getRoomAddBudgetFlag() {
		return roomAddBudgetFlag;
	}
	public void setRoomAddBudgetFlag(int roomAddBudgetFlag) {
		this.roomAddBudgetFlag = roomAddBudgetFlag;
	}
	public String getRoomAddBudgetRemark() {
		return roomAddBudgetRemark;
	}
	public void setRoomAddBudgetRemark(String roomAddBudgetRemark) {
		this.roomAddBudgetRemark = roomAddBudgetRemark;
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
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public SupplementDetail getSupplementDetail() {
		return supplementDetail;
	}
	public void setSupplementDetail(SupplementDetail supplementDetail) {
		this.supplementDetail = supplementDetail;
	}
	public int getAccidentInsurance() {
		return accidentInsurance;
	}
	public void setAccidentInsurance(int accidentInsurance) {
		this.accidentInsurance = accidentInsurance;
	}
	
}
