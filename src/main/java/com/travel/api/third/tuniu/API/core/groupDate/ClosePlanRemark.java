package com.travel.api.third.tuniu.API.core.groupDate;

/** 
 * <p>Title: ClosePlanRemark.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.groupDate</p>  
 * <p>Description:关团说明信息</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ClosePlanRemark {
	private int clearStock;//	int	否	1	是否同时清库，0=>不清库;1=>清库
	private int clearStockType;//	int	否	1	清除库存类型：0=>不清库;1=>清除独享库存;2=>清除共享库存
	private int reason;//	int	否	0	关团原因。否则：1=>满位;2=>不成团;0=>其他
	private String 	remark;//	Varchar(1024)	否	＂关团说明＂	关团说明
	public int getClearStock() {
		return clearStock;
	}
	public void setClearStock(int clearStock) {
		this.clearStock = clearStock;
	}
	public int getClearStockType() {
		return clearStockType;
	}
	public void setClearStockType(int clearStockType) {
		this.clearStockType = clearStockType;
	}
	public int getReason() {
		return reason;
	}
	public void setReason(int reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
