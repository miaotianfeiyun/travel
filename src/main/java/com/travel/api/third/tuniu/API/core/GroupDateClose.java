package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.core.groupDate.ClosePlanRemark;

/** 
 * <p>Title: GroupDateOpenOrClose.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class GroupDateClose {
	private String agencyProductId;//	Varchar(100)	是	test10001	供应商产品编号：由供应商自行保证每个操作的产品都存在这个值，且该值在该供应商所有产品下无重复。
	private String groupNum;//	Varchar(100)	否	“0”	支持供应商一个产品id对应多个团的情况，如不传该字段，表明只支持单个团
	private String schemeId;//	Varchar(64)	否	Sheme0001	为空时表示对基础操作，否则，操作相应升级方案
	private String planDateStr;//	Varchar(10)	是	2015-05-28	只支持单条
	private ClosePlanRemark  closePlanRemark;//	ClosePlanRemark	是	
	public String getAgencyProductId() {
		return agencyProductId;
	}
	public void setAgencyProductId(String agencyProductId) {
		this.agencyProductId = agencyProductId;
	}
	public String getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public String getPlanDateStr() {
		return planDateStr;
	}
	public void setPlanDateStr(String planDateStr) {
		this.planDateStr = planDateStr;
	}
	public ClosePlanRemark getClosePlanRemark() {
		return closePlanRemark;
	}
	public void setClosePlanRemark(ClosePlanRemark closePlanRemark) {
		this.closePlanRemark = closePlanRemark;
	}
	
}
