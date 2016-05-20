package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.BaseParameters;
import com.travel.api.third.tuniu.API.core.group_date_price.PlanInfo;

/** 
 * <p>Title: PlanInfo.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:团期管理</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class GroupDatePrice extends BaseParameters{
	private String agencyProductId;//	Varchar(100)	是	test10001	供应商产品编号：由供应商自行保证每个操作的产品都存在这个值，且该值在该供应商所有产品下无重复。
	private String groupNum;//	Varchar(100)	否	“0”	支持供应商一个产品id对应多个团的情况，如不传该字段，表明只支持单个团
	private PlanInfo[] planInfo;//	PlanInfo[]	是		要新增/修改的信息
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
	public PlanInfo[] getPlanInfo() {
		return planInfo;
	}
	public void setPlanInfo(PlanInfo[] planInfo) {
		this.planInfo = planInfo;
	}
	
}
