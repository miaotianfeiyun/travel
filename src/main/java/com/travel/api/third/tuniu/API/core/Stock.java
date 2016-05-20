package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.BaseParameters;

/** 
 * <p>Title: Stock.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:针对某一产品某团期修改库存信息。（无则新增，存在则修改为当前值）。 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class Stock extends BaseParameters{
	
	private String agencyProductId;//	Varchar(100)	是	test10001	供应商产品编号：由供应商自行保证每个操作的产品都存在这个值，且该值在该供应商所有产品下无重复。
	private String groupNum;//	Varchar(100)	否	“0”	支持供应商一个产品id对应多个团的情况，如不传该字段，表明只支持单个团
	private String schemeId;//	Varchar(64)	否	Sheme0001	为空时表示对基础操作，否则，操作相应升级方案
	private String planDateStr;//	Varchar(10)	是	2015-05-28	单个团期，暂不支持批量
	private int stockNum;//	int	是	10	库存修改后的余位数
	private int autoClearDay;//	int	是	1	库存自动清位时间-天
	private int clearPosHour;//	int	是	1	库存自动清位时间-时
	
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
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public int getAutoClearDay() {
		return autoClearDay;
	}
	public void setAutoClearDay(int autoClearDay) {
		this.autoClearDay = autoClearDay;
	}
	public int getClearPosHour() {
		return clearPosHour;
	}
	public void setClearPosHour(int clearPosHour) {
		this.clearPosHour = clearPosHour;
	}
	
}
