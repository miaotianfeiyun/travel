package com.travel.api.third.tuniu.API.core.productAuditStatus;

/** 
 * <p>Title: ProductStatusInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.productAuditStatus</p>  
 * <p>Description:产品审核状态查询 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月21日 
 * @version :1.0
 */

public class ProductStatusInfo {
	/** 
	* 供应商产品编号
	*/ 
	private String agencyProductId;
	/** 
	* 支持供应商一个产品id对应多个团的情况，如不传该字段，表明查供应商产品编号状态
	*/ 
	private String groupNum;
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
	
}
